package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Voley.*;

public class VoleyTestCase {
	private Voley deporte = new Voley();

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Voley");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertTrue(deporte.permiteEmpate());
	}
}
