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

package models.juego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

// Importa utilidades Java
import java.util.Date;

// Importa desde org
import org.junit.Test;

import competidor.Competidor;
import deporte.Deporte;
import juego.Partido;

public class PartidoTestCase {
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
	private Date fecha = new Date(2018, 06, 23); // Se crea para tener la fecha
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");

	@Test
	public void testPartidoDevuelveLocal() {
		assertEquals(partido.getLocal(), this.local);
	}

	@Test
	public void testPartidoDevuelveVisitante() {
		assertEquals(partido.getVisitante(), this.visitante);
	}

	// TODO: Implementar estados
	@Test
	public void testPartidoDevuelveEstado() {
		assertEquals(partido.getEstado(), this.local); // Implementar estados
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPartidoDevuelveFechaDeJuego() {
		assertEquals(partido.getFecha(), this.fecha.getDate());
	}

	@Test
	public void testPartidoPreguntaSiJuegaLocal() {
		assertTrue(partido.juega(this.local));
	}

	@Test
	public void testPartidoPreguntaSiJuegaOtro() {
		assertFalse(partido.juega(mock(Competidor.class)));
	}
}
