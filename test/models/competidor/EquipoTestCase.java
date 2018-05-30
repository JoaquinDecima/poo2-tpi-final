package models.competidor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.competidor.Deportista.*;
import models.competidor.Equipo.*;

public class DeportistaTest {
  protected ArrayList<Deportista> deportistas = [mock(Deportista.class), mock(Deportista.class), mock(Deportista.class)]; //En caso de que no funcione agregar manualmente
  private Equipo cervezero = new Equipo("Quilmes", deportistas);

	@Test
	public void cervezeroRespondeSuNombre() {
		assertEquals(cervezero.getNombre(), "Quilmes");
	}

  @Test
	public void cervezeroRetornaCantDeJugadores() {
		assertEquals(cervezero.getCantDeJugadores(), this.deportistas.size());
	}

  @Test
	public void cervezeroAgregaUnJugado() {
    this.cervezero.addJugador(mock(Deportista.class))

		assertEquals(cervezero.getCantDeJugadores(), 4);
	}
}
