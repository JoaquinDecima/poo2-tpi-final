package models.apuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import models.apuesta.ApuestaFinal;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public class ApuestaFinalTestCase {
	private Usuario usuario = mock(Usuario.class);
	private Evento evento = mock(Evento.class);
	private OpcionApuesta opcionApuesta = mock(OpcionApuesta.class);
	private ApuestaFinal apuesta = new ApuestaFinal(evento, usuario, opcionApuesta, 260.0);
	
	@Test
	public void testMonto() {
		assertEquals(apuesta.montoApostado(),260.0,0.5);
	}

	@Test
	public void testOpcionApuesta() {
		assertEquals(apuesta.opcionApostada(), opcionApuesta);
	}
	
	@Test
	public void testEvento() {
		assertEquals(apuesta.getEvento(), evento);
	}
	
	@Test
	public void testUsuario() {
		assertEquals(apuesta.getUsuario(), usuario);
	}
	
	@Test
	public void testPartido() {
		apuesta.getPartido();
		verify(evento).getPartidoDelEvento();
	}
}
