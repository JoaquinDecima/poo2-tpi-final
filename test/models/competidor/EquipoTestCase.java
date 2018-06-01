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
import static org.mockito.Mockito.*;

//Importa Utilidades Java
import java.util.ArrayList;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.competidor.*;

public class EquipoTestCase {
  protected ArrayList<Deportista> deportistas = new ArrayList<Deportista>(); //En caso de que no funcione agregar manualmente
  private Equipo cervezero = new Equipo("Quilmes", deportistas);

	@Test
	public void cervezeroRespondeSuNombre() {
		assertEquals(cervezero.getNombre(), "Quilmes");
	}

  @Test
	public void cervezeroRetornaCantDeJugadores() {
	  	this.deportistas.add(mock(Deportista.class));
	  	this.deportistas.add(mock(Deportista.class));
	  	this.deportistas.add(mock(Deportista.class));
	  	
		assertEquals(cervezero.getCantDeJugadores(), 3);
	}

  @Test
	public void cervezeroAgregaUnJugado() {
    this.cervezero.addJugador(mock(Deportista.class));

		assertEquals(cervezero.getCantDeJugadores(), 1);
	}
}
