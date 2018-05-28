package models.deporte;

import static org.junit.Assert.*;
import org.junit.Test;

import models.deporte.Deporte.*;

public class DeporteTestCase {
	private Deporte deporte = new Deporte("Futbol", True);

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.getNombre, "Futbol");
	}

	@Test
	public void testdeporteRespondeNombre() {
		assertEquals(deporte.permiteEmpate, True); 	// Verificar Muerto
	}
}
