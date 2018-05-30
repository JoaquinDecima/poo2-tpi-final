package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Tenis.*;

public class TenisTestCase {
	private Tenis deporte = new Tenis();

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Tenis");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertFalse(deporte.permiteEmpate());
	}
}
