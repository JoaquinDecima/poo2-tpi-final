package models.juego.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import models.juego.Partido;

public class ProximoTestCase {
	private Proximo estado = new Proximo();
	private Partido partido = mock(Partido.class);
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "Proximo");
	}

	@Test
	public void testResultado() {
		assertEquals(estado.resultadoPartido(partido), null);
	}
}
