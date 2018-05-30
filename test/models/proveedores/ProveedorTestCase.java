package models.proveedores;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa desde org
import org.junit.Test;

// Importa del Modelo
import models.proveedores.Proveedor.*;

public class ProveedorTestCase {
  private ProveedorDePartido partidos = mock(ProveedorDePartido.class);
  private ProveedorDeEstadistica estadistica = mock(ProVeedorDeEstadistica.class);
  private Proveedor proveedor = new Proveerdor(partidos, estadistica);

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
