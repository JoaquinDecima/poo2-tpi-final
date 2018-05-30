package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Deporte.*;

public class DeporteTestCase {
	private Deporte deporte = new Deporte("Futbol", True);

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Futbol");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertTrue(deporte.permiteEmpate());
	}
}
