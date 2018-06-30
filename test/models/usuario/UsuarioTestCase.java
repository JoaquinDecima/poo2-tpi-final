/**
 *
 */
package models.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.Test;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.casaApuesta.CasaApuesta;
import models.competidor.Competidor;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.estado.EnCurso;
import models.usuario.Usuario;


public class UsuarioTestCase {

	private Usuario usuario = new Usuario("diego", "diego@unq.edu.ar");
	private CasaApuesta mockCasaApuesta = mock(CasaApuesta.class);
	private Partido mockPartido = mock(Partido.class);
	private Evento evento = new Evento(mockPartido, mockCasaApuesta.getAdminCuota());
	private OpcionApuesta mockOpcionApuesta = mock(OpcionApuesta.class);
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
	private Date fecha = new Date(2018, 06, 23); // Se crea para tener la fecha
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");


	@Test
	public void testCuandoUsuarioCancelaApuestaSeguraConPartidoEnCursoSePenalizaCobrando30porcientoApostado() {

		assertEquals(usuario.getMontoWallet(), 0.00, 0.00);
		// seteo 200 pesos en wallet de usuario
		usuario.incrementarMontoWallet(200.00);
		// compruebo que existen 200 pesos en wallet de usuario
		assertEquals(usuario.getMontoWallet(), 200.00, 200.00);
		// chequeo que el usuario no ha hecho apuestas en evento
		assertEquals(0, evento.getApuestasUsuario(usuario).size(), 0);
		// usuario hace apuestaSegura en evento
		usuario.hacerApuestaSegura(mockOpcionApuesta, 150.00);
		// compruebo que se han descontado 150 pesos de wallet de usuario
		assertEquals(usuario.getMontoWallet(), 50.00, 50.00);
		// compruebo que ha quedado registrada en el evento la apuesta hecha
		assertEquals(1, evento.getApuestasUsuario(usuario).size(), 1);
		// usuario cancela apuesta segura con partido en curso
		partido.setEstado(new EnCurso());
		usuario.cancelarApuesta((ApuestaSegura) (evento.getApuestasUsuario(usuario)).get(0));
		// compruebo que usuario vuelve a poseer el dinero previo a la apuesta, con una quita del 30 porciento
		assertEquals(usuario.getMontoWallet(), 155, 155);
		// compruebo que se ha quitado la apuesta del registro en el evento
		assertFalse(((ApuestaSegura) evento.getApuestasUsuario(usuario).get(0)).estaActiva());

		assertEquals(usuario.getNombre(), "diego");
	}

	@Test
	public void testEmail() {
		assertEquals(usuario.getEmail(), "diego@unq.edu.ar");
		usuario.setEmail("diego@gmail.com");
		assertEquals(usuario.getEmail(), "diego@gmail.com");
	}
}
