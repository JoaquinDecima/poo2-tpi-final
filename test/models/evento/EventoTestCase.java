package models.evento;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import models.apuesta.Apuesta;
import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.juego.Partido;
import models.juego.resultado.ResultadoSinEmpate;
import models.usuario.Usuario;

public class EventoTestCase {


	@SuppressWarnings("unused")
	private Usuario usuario;
	private AdminCuota adminCuota;
	@SuppressWarnings("unused")
	private OpcionApuesta opcionApuesta;
	private Partido mockPartido;
	private Evento evento;
	private Date fecha = new Date();
	private ResultadoSinEmpate resultadoVictoriaLocal;
	private ResultadoSinEmpate resultadoVictoriaVisitante;
	private OpcionApuesta opcionApuesta1VictoriaVisitante;
	private OpcionApuesta opcionApuestaVictoriaLocal;
	
	

	@Before
	public void setUp() {
		adminCuota = mock(AdminCuota.class);
		mockPartido = mock(Partido.class);
		evento = new Evento(mockPartido, adminCuota);
		opcionApuesta = mock(OpcionApuesta.class);
		resultadoVictoriaLocal = new ResultadoSinEmpate(local, visitante);
		resultadoVictoriaVisitante = new ResultadoSinEmpate(visitante, local);
		
		opcionApuestaVictoriaLocal = new OpcionApuesta(resultadoVictoriaLocal, 2.00);
		opcionApuesta1VictoriaVisitante = new OpcionApuesta(resultadoVictoriaVisitante, 3.00);
		
		when(mockPartido.getLocal()).thenReturn(local);
		when(mockPartido.getVisitante()).thenReturn(visitante);
		
			
	}


	private Competidor local = mock(Competidor.class);
	private Competidor visitante = mock(Competidor.class);

	
	
	
	@Test
	public void testPartido() {
		assertEquals(evento.getPartidoDelEvento(), mockPartido);
	}

	@Test
	public void testEventoRetornaListaDeOpcionesDeResultadosPosibles() {
		

		
		when(adminCuota.getCuotaPorVictoriaLocal(mockPartido)).thenReturn(2.00);
		when(adminCuota.getCuotaPorVictoriaVisitante(mockPartido)).thenReturn(3.00);
	
		when(mockPartido.esDeporteConEmpate()).thenReturn(false);	
			 		
		evento.calcularOpcionesResultadosPosibles();
		
		assertEquals(evento.calcularOpcionVictoriaVisitante().cuota(), opcionApuesta1VictoriaVisitante.cuota());
		assertEquals(evento.calcularOpcionVictoriaVisitante().resultado().ganaCompetidor(), opcionApuesta1VictoriaVisitante.resultado().ganaCompetidor());
		
		assertEquals(evento.calcularOpcionVictoriaLocal().cuota(), opcionApuestaVictoriaLocal.cuota());
		assertEquals(evento.calcularOpcionVictoriaLocal().resultado().ganaCompetidor(), opcionApuestaVictoriaLocal.resultado().ganaCompetidor());
		
		
		
	}

	@Test
	public void testResultado() {
		evento.getResultadoPartido();
		verify(mockPartido).getResultado();
	}

	@Test
	public void testApuestaRealizadas() {
		//TODO
		assertEquals(evento.getApuestasRealizadas(), new ArrayList<Apuesta>());
	}

	@Test
	public void testGetResultados() {


		assertEquals(evento.getResultadoVictoriaLocal().ganaCompetidor(), local);
		assertEquals(evento.getResultadoVictoriaVisitante().ganaCompetidor(), visitante);
		assertTrue(evento.getResultadoEmpate().empate());
	}
	
	@Test
	public void testPideFecha() {
		when(mockPartido.getFechaDate()).thenReturn(fecha);
		assertEquals(evento.getFecha(), fecha);
		
	}
	
	@Test
	public void testDisponibilidad() {
		assertTrue(evento.estaDisponible());
		evento.quitarDisponibilidad();
		assertFalse(evento.estaDisponible());
	}
}
