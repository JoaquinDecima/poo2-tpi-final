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

package models.proveedores;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.proveedores.Proveedor.*;

public class ProveedorTestCase {
  private ProveedorDePartido partidos = mock(ProveedorDePartido.class);
  private ProveedorDeEstadistica estadistica = mock(ProveedorDeEstadistica.class);
  private Proveedor proveedor = new Proveedor(partidos, estadistica);

	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
