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
import models.deporte.Tenis;

public class TenisTestCase {
	private Tenis deporte = new Tenis();

	@Test
	public void tenisRespondeNombre() {
		assertEquals(deporte.getNombre(), "Tenis");
	}

	@Test
	public void tenisRespondeSiPermiteEmpate() {
		assertFalse(deporte.permiteEmpate());
	}
}
