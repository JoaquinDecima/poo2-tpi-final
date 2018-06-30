package models.evento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.cuota.AdminCuota;
import models.evento.Evento;
import models.juego.Partido;
import models.usuario.Usuario;
import models.apuesta.Apuesta;
import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;

public class EventoTestCase {


	private Usuario usuario;
	private AdminCuota adminCuota;
	private OpcionApuesta opcionApuesta;
	private Partido mockPartido;
	private Evento evento;

	@Before
	void setUp() {
		adminCuota = mock(AdminCuota.class);
		mockPartido = mock(Partido.class);
		evento = new Evento(mockPartido, adminCuota);
		opcionApuesta = mock(OpcionApuesta.class);
			
	}



	private Competidor local = mock(Competidor.class);
	private Competidor visitante = mock(Competidor.class);

	@Test
	public void testPartido() {
		assertEquals(evento.getPartidoDelEvento(), mockPartido);
	}

	@Test
	public void testApuestaPosibles() {
		// TODO: Corregir implementacion
		assertEquals(evento.getOpcionesResultadosPosibles(),null);
	}

	@Test
	public void testResultado() {
		evento.getResultadoPartido();
		verify(mockPartido).getResultado();
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
