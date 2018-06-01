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
import models.deporte.*;

public class FutbolTestCase {
	private Futbol deporte = new Futbol();

	@Test
	public void futbolRespondeNombre() {
		assertEquals(deporte.getNombre(), "Futboll");
	}

	@Test
	public void futbolRespondeSiPermiteEmpate() {
		assertTrue(deporte.permiteEmpate());
	}
}
