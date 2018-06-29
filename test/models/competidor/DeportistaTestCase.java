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

import java.util.Date;
import org.junit.Test;


public class DeportistaTestCase {
	private String sNombre = "Pato";
	private String sLugarNatal = "Quilmes";
	@SuppressWarnings("deprecation")
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
