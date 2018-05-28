package models.competidor;

import static org.junit.Assert.*;
import org.junit.Test;

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
        deportistaPato = new Deportista("Pato","Quilmes"); //Falta agregar fecha
        deportistaSinNombre = new Deportista("", "La Plata") //Falta agregar fecha

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
