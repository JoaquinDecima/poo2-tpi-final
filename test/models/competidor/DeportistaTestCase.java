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
import models.competidor.Deportista.*;

public class DeportistaTest {
	private Deportista deportistaPato;
	private Deportista deportistaSinNombre;

	/**
     * Crea un escenario de test básico, que contiene un deportista
     *
     *
     * @throws Exception
     */
	public void setUp() throws Exception {

        //Se crea el contador
        deportistaPato = new Deportista("Pato","Quilmes", new Date(1996, 3, 29));
        deportistaSinNombre = new Deportista("", "La Plata", new Date(1995, 8, 9));

    }


	@Test
	public void testPatoRespondeNombre() {
		assertEquals(deportistaPato.getNombre, "Pato");
	}

	@Test
	public void testPatoRespondeLugarDeNacimiento() {
		assertEquals(deportistaPato.getLugarNatal, "Quilmes");
	}
}
