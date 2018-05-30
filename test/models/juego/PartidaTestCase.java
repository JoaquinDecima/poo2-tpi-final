package models.juego;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa utilidades Java
import java.util.Date;

// Importa de Mi modelo
import models.competidor.Deportista.*;
import models.deporte.Deporte.*;
import models.juego.Patrida.*;

// Importa desde org
import org.junit.Test;

public class PartidaTestCase {
	private Competidor local = mock(Deportista.class) ;
	private Competidor visitante = mock(Deportista.class);
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
		assertEquals(partido.getEstado(), this.local);
	}

	@Test
	public void testPartidoDevuelveFechaDeJuego() {
		assertEquals(partido.getFechaDeJuego(), this.fecha.getDate());
	}
}
