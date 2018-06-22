package models.evento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cuota.AdminCuota;
import evento.Evento;
import juego.Partido;
import apuesta.Apuesta;

public class EventoTestCase {
	private Partido partido = mock(Partido.class);
	private AdminCuota adminCuota = mock(AdminCuota.class);
	private Evento evento = new Evento(partido, adminCuota);
	
	@Test
	public void testPartido() {
		assertEquals(evento.getPartidoDelEvento(), partido);
	}
	
	@Test
	public void testApuestaPosibles() {
		// TODO: Corregir implementacion
		assertEquals(evento.getOpcionesResultadosPosibles(),null);
	}
	
	@Test
	public void testResultado() {
		evento.getResultadoPartido();
		verify(partido).getResultado();
	}
	
	@Test
	public void testApuestaRealizadas() {
		assertEquals(evento.getApuestasRealizadas(), new ArrayList<Apuesta>());
	}
}
