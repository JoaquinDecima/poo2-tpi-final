package models.juego.estado;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.estado.*;

public class ProximoTestCase {
	private Proximo estado = new Proximo();
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "Proximo");
	}

}
