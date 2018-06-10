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
import models.competidor.*;

public class DeportistaTestCase {
	private Deportista deportistaPato;

	/**
     * Crea un escenario de test basico, que contiene un deportista
     *
     *
     * @throws Exception
     */
	public void setUp() throws Exception {

        //Se crea el contador
        deportistaPato = new Deportista("Pato","Quilmes", new Date(1996, 3, 29));	// TODO: Verificar uso de Date
    }


	@Test
	public void testPatoRespondeNombre() {
		assertEquals(deportistaPato.getNombre(), "Pato");
	}

	@Test
	public void testPatoRespondeLugarDeNacimiento() {
		assertEquals(deportistaPato.getLugarNatal(), "Quilmes");
	}
}
