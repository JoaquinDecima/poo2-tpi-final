package models.juego;

import static org.junit.Assert.*;

import java.util.Date;
import models.juego.Patrida.*;
import org.junit.Test;

public class PartidaTestCase {
	private Competidor local = new Deportista(); // Mokear
	private Competidor visitante = new Deportista(); // Mokear
	private Deporte deporte = new Deporte(); // Mokear
	private Date fecha = new Date(2018, 06, 23);
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");

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

	@Test
	public void testPartidoDevuelveFechaDeJuego() {
		assertEquals(partido.getFechaDeJuego, this.fecha.getDate()); // Refactorizar
	}
}
