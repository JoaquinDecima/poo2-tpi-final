package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Boxeo.*;

public class BoxeoTestCase {
	private Boxeo deporte = new Boxeo();

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Boxeo");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertFalse(deporte.permiteEmpate());
	}
}
