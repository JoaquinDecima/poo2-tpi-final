package models.juego.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.juego.Partido;
import models.usuario.Usuario;

public class FinalizadoTestCase {
	private Finalizado estado = new Finalizado();
	private Partido partido = mock(Partido.class);
	
	private Evento evento = mock(Evento.class);
	private Usuario usuario = mock(Usuario.class);
	private OpcionApuesta opcionApuesta = mock(OpcionApuesta.class);
	private ApuestaSegura apuesta = mock(ApuestaSegura.class);
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "Finalizado");
	}

	@Test
	public void testResultado() {
		estado.resultadoPartido(partido);
		verify(partido).resultado();
	}
	
	@Test(expected=Exception.class)
	public void testAddApuesta() throws Exception {
		estado.addApuesta(evento, usuario, opcionApuesta, 100, true);
	}
	
	@Test(expected=Exception.class)
	public void testCancelarApuesta() throws Exception {
		estado.cancelarApuestaSegura(apuesta);
	}
	
	@Test(expected=Exception.class)
	public void testReactivarApuesta() throws Exception {
		estado.reactivarApuestaSegura(apuesta);
	}
}
