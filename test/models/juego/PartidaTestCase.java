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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa utilidades Java
import java.util.Date;

// Importa de Mi modelo
import models.competidor.*;
import models.deporte.*;
import models.juego.*;
import models.juego.estado.*;

// Importa desde org
import org.junit.Test;

public class PartidaTestCase {
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

	@Test
	public void testPartidoDevuelveEstado() {
		assertEquals(partido.getEstado(), this.local); // Implementar estados
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPartidoDevuelveFechaDeJuego() {
		assertEquals(partido.getFechaDeJuego(), this.fecha.getDate());
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
