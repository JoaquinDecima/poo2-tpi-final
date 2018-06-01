/*
 * Programacion Orientada a Objetos II 2018 s1
 * Universidad Nacional de Quilmes
 *
 * Casa de Apuestas HITO 1
 *
 * Alumnos:
 *        Decima, Joaquin A. (Pato)
 *        Otarola, Florencia
 */

package models.deporte;

import static org.junit.Assert.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.deporte.Deporte.*;

public class DeporteTestCase {
	private Deporte deporte = new Deporte("Futbol", true);

	@Test
	public void testDeporteRespondeNombre() {
		assertEquals(deporte.getNombre(), "Futbol");
	}

	@Test
	public void testDeporteSiPermiteEmpate() {
		assertTrue(deporte.permiteEmpate());
	}
}
