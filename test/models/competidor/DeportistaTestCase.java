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

package models.competidor;

import static org.junit.Assert.*;

// Importa Utilidades Java
import java.util.Date;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import competidor.*;

public class DeportistaTestCase {
	private String sNombre = "Pato";
	private String sLugarNatal = "Quilmes";
	private Deportista deportistaPato = new Deportista(sNombre, sLugarNatal, new Date(1996, 3, 29));
	

	@Test
	public void testPatoRespondeNombre() {
		assertEquals(deportistaPato.getNombre(), sNombre);
	}

	@Test
	public void testPatoRespondeLugarDeNacimiento() {
		assertEquals(deportistaPato.getLugarNatal(), sLugarNatal);
	}
}
