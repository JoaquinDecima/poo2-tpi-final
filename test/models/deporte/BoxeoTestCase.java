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
import models.deporte.Boxeo.*;

public class BoxeoTestCase {
	private Boxeo deporte = new Boxeo();

	@Test
	public void BoxeoRespondeNombre() {
		assertEquals(deporte.getNombre(), "Boxeo");
	}

	@Test
	public void BoxeoRespondeSiPermiteEmpate() {
		assertFalse(deporte.permiteEmpate());
	}
}
