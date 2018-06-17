/**
 * 
 */
package models.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import apuesta.Apuesta;
import apuesta.OpcionApuesta;
import casaApuesta.CasaApuesta;
import evento.Evento;
import juego.Partido;
import usuario.Usuario;


public class UsuarioTestCase {
	
	private Usuario usuario;
	private CasaApuesta mockCasaApuesta;
	private Evento evento;
	private Partido mockPartido;
	private OpcionApuesta mockOpcionApuesta;
	
	@Before
	public void setUp(){
		
		mockCasaApuesta = mock(CasaApuesta.class);
		mockPartido = mock(Partido.class);
		usuario = new Usuario("diego");
		evento = new Evento(mockPartido, mockCasaApuesta.getAdminCuota());
		mockOpcionApuesta = mock(OpcionApuesta.class);
		
		
	}

	@Test
	public void testCuandoUsuarioCancelaApuestaSeguraConPartidoEnCursoSePenalizaCobrando30porcientoApostado() {
				
		Apuesta apuestaSegura;
		ArrayList<Apuesta> apuestasUsuarios;
		boolean existeApuesta;
		
		// seteo 200 pesos en wallet de usuario
		usuario.incrementarMontoWallet(200);
		// compruebo que existen 200 pesos en wallet de usuario
		assertEquals(usuario.getMontoWallet(), 200, 200);
		// usuario hace apuestaSegura
		apuestaSegura = usuario.hacerApuestaSegura(evento, mockOpcionApuesta, 150);
		// compruebo que se han descontado 150 pesos de wallet de usuario
		assertEquals(usuario.getMontoWallet(), 50, 50);
		// compruebo que ha quedado registrada en el evento la apuesta hecha
		apuestasUsuarios = evento.getApuestasUsuario(usuario, evento);
		existeApuesta = apuestasUsuarios.stream().anyMatch(a -> a.equals(apuestaSegura));
		assertTrue(existeApuesta);		
		// usuario cancela apuesta segura con partido en curso
		assertTrue(evento.getPartidoDelEvento().enCurso());
		usuario.cancelarApuesta();
		// compruebo que usuario vuelve a poseer el dinero previo a la apuesta, con una quita del 30 porciento
		assertEquals(usuario.getMontoWallet(), 155, 155);
		// compruebo que se ha quitado la apuesta del registro en el evento
		assertFalse(existeApuesta);
		
	}


}
