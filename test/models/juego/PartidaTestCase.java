package models.juego;

import static org.junit.Assert.*;
import org.junit.Test;

import models.juego.Patrida.*;

public class PartidaTestCase {
	private Competidor local = new Deportista(); // Mokear
	private Competidor visitante = new Deportista(); // Mokear
	private Deporte deporte = new Deporte(); // Mokear
	private Partido partido = new Partido(local, visitante, deporte, "fecha" /*cambiar a formato fecha*/, "Quilmes");

	@Test
	public void testPartidoDevuelveLocal() {
		assertEquals(partido.getLocal, this.local);
	}

	@Test
	public void testPartidoDevuelveVisitante() {
		assertEquals(partido.getVisitante, this.visitante);
	}

	@Test
	public void testPartidoDevuelveEstado() {
		assertEquals(partido.getEstado, this.local); // Refactorizar
	}
}
