package models.evento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

import models.cuota.AdminCuota;
import models.evento.Evento;
import models.juego.Partido;
import models.apuesta.Apuesta;
import models.competidor.Competidor;

public class EventoTestCase {
	private Partido partido = mock(Partido.class);
	private AdminCuota adminCuota = mock(AdminCuota.class);
	private Evento evento = new Evento(partido, adminCuota);
	
	private Competidor local = mock(Competidor.class);
	private Competidor visitante = mock(Competidor.class);
	
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
	
	@Test
	public void testGetResultados() {
		when(partido.getLocal()).thenReturn(local);
		when(partido.getVisitante()).thenReturn(visitante);
		
		assertEquals(evento.getResultadoVictoriaLocal().ganaCompetidor(), local);
		assertEquals(evento.getResultadoVictoriaVisitante().ganaCompetidor(), visitante);
		assertTrue(evento.getResultadoEmpate().empate());
	}
}
