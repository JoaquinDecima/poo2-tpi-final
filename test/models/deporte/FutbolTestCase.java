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

import org.junit.Test;


public class FutbolTestCase {
	private Futbol deporte = new Futbol();

	@Test
	public void futbolRespondeNombre() {
		assertEquals(deporte.getNombre(), "Futbol");
	}

	@Test
	public void futbolRespondeSiPermiteEmpate() {
		assertTrue(deporte.permiteEmpate());
	}
}
