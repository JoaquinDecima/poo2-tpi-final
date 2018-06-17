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
import deporte.Voley;

public class VoleyTestCase {
	private Voley deporte = new Voley();

	@Test
	public void voleyRespondeNombre() {
		assertEquals(deporte.getNombre(), "Voley");
	}

	@Test
	public void voleyRespondeSiPermiteEmpate() {
		assertTrue(deporte.permiteEmpate());
	}
}
