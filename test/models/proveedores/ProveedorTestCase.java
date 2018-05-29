package models.provedores;

import static org.junit.Assert.*;
import org.junit.Test;

import models.apuesta.Apuesta.*;

public class proveedorTestCase {
  private ProVeedorDePartido partidos = new ProVeedorDePartido(); // Mokear
  private ProVeedorDeEstadistica estadistica = new ProVeedorDeEstadistica(); // Mokear
  private Proveerdor proveedor = new Proveerdor(partidos, estadistica); 

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
