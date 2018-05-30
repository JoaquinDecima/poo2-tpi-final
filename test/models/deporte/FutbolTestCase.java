package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Futboll.*;

public class FutbolTestCase {
	private Futboll deporte = new Futboll();

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Futboll");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertTrue(deporte.permiteEmpate());
	}
}
