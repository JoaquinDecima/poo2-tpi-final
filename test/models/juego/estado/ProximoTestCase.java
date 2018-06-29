package models.juego.estado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import juego.Partido;
import juego.estado.*;

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
