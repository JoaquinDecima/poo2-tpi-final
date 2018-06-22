package models.juego.estado;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.estado.*;

public class FinalizadoTestCase {
	private Finalizado estado = new Finalizado();
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "Finalizado");
	}

}
