package models.competidor;

import static org.junit.Assert.*;

import java.util.Date;
import models.competidor.Deportista.*;
import org.junit.Test;

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
