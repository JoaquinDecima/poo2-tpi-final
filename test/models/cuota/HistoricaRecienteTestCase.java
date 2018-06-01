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

package models.cuota;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.competidor.Competidor.*;
import models.cuota.HistoricaReciente.*;

public class HistoricaRecienteTestCase {
  private Competidor local = mock(Competidor.class);
  private Competidor visitante = mock(Competidor.class);
  private HistoricaReciente cuota = new HistoricaReciente();

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
