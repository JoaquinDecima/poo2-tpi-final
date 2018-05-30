package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Basquetball.*;

public class BasquetballTestCase {
	private Basquetball deporte = new Basquetball();

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Basquetball");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertTrue(deporte.permiteEmpate());
	}
}
