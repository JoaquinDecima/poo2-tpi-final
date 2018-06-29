package models.juego.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import juego.Partido;
import juego.estado.*;

public class FinalizadoTestCase {
	private Finalizado estado = new Finalizado();
	private Partido partido = mock(Partido.class);
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "Finalizado");
	}

	@Test
	public void testResultado() {
		estado.resultadoPartido(partido);
		verify(partido).getResultado();
	}
}
