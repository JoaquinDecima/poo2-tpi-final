/**
 * 
 */
package models.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import apuesta.ApuestaSegura;
import apuesta.OpcionApuesta;
import casaApuesta.CasaApuesta;
import evento.Evento;
import juego.Partido;
import usuario.Usuario;


public class UsuarioTestCase {
	
	private Usuario usuario = new Usuario("diego");
	private CasaApuesta mockCasaApuesta = mock(CasaApuesta.class);
	private Partido mockPartido = mock(Partido.class);
	private Evento evento = new Evento(mockPartido, mockCasaApuesta.getAdminCuota());
	private OpcionApuesta mockOpcionApuesta = mock(OpcionApuesta.class);
	
	@Test
	public void testCuandoUsuarioCancelaApuestaSeguraConPartidoEnCursoSePenalizaCobrando30porcientoApostado() {
		
		System.out.println(usuario.getMontoWallet());			
		assertEquals(usuario.getMontoWallet(), 0.00, 0.00);
		// seteo 200 pesos en wallet de usuario
		usuario.incrementarMontoWallet(200.00);
		// compruebo que existen 200 pesos en wallet de usuario
		assertEquals(usuario.getMontoWallet(), 200.00, 200.00);
		System.out.println(usuario.getMontoWallet());
		// chequeo que el usuario no ha hecho apuestas en evento 
		System.out.println(evento.getApuestasUsuario(usuario).size());
		assertEquals(0, evento.getApuestasUsuario(usuario).size(), 0);
		// usuario hace apuestaSegura en evento
		usuario.hacerApuestaSegura(evento, mockOpcionApuesta, 150.00);
		// compruebo que se han descontado 150 pesos de wallet de usuario
		assertEquals(usuario.getMontoWallet(), 50.00, 50.00);
		System.out.println(usuario.getMontoWallet());
		// compruebo que ha quedado registrada en el evento la apuesta hecha
		System.out.println(evento.getApuestasUsuario(usuario).size());
		assertEquals(1, evento.getApuestasUsuario(usuario).size(), 1);
		// usuario cancela apuesta segura con partido en curso
		when(mockPartido.enCurso()).thenReturn(true);		
		usuario.cancelarApuesta((ApuestaSegura) (evento.getApuestasUsuario(usuario)).get(0));
		// compruebo que usuario vuelve a poseer el dinero previo a la apuesta, con una quita del 30 porciento
		assertEquals(usuario.getMontoWallet(), 155, 155);
		System.out.println(usuario.getMontoWallet());
		// compruebo que se ha quitado la apuesta del registro en el evento
		System.out.println(evento.getApuestasUsuario(usuario).size());
		assertFalse(((ApuestaSegura) evento.getApuestasUsuario(usuario).get(0)).estaActiva());	
		
		assertEquals(usuario.getNombre(), "diego");
	}


}
