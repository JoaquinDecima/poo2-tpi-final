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
import models.apuesta.ApuestaFinal;
import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.juego.Partido;
import models.juego.estado.EnCurso;
import models.juego.estado.Proximo;
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
	private Proximo estadoPartidoProximo;
	private EnCurso estadoPartidoEnCurso;
	private ApuestaFinal mockApuestaFinal;

	

	@Before
	public void setUp() {
		
		
		adminCuota = mock(AdminCuota.class);
		mockPartido = mock(Partido.class);
		estadoPartidoProximo = new Proximo();
		estadoPartidoEnCurso = new EnCurso();
		evento = new Evento(mockPartido, adminCuota);
		opcionApuesta = mock(OpcionApuesta.class);
		resultadoVictoriaLocal = new ResultadoSinEmpate(local, visitante);
		resultadoVictoriaVisitante = new ResultadoSinEmpate(visitante, local);
		mockApuestaFinal = mock(ApuestaFinal.class);
		
		opcionApuestaVictoriaLocal = new OpcionApuesta(resultadoVictoriaLocal, 2.00);
		opcionApuesta1VictoriaVisitante = new OpcionApuesta(resultadoVictoriaVisitante, 3.00);
		usuario = new Usuario("diego", "diego@unq.edu.ar");
		
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
	
		when(mockPartido.esDeporteConEmpate()).thenReturn(true);	
			 		
		evento.calcularOpcionesResultadosPosibles();
		
		OpcionApuesta opcionApuestaVicLocalCalculadoPorEvento = evento.calcularOpcionVictoriaLocal();
		OpcionApuesta opcionApuestaVicVisitanteCalculadoPorEvento = evento.calcularOpcionVictoriaVisitante();
		OpcionApuesta opcionApuestaEmpateCalculadoPorEvento = evento.calcularOpcionEmpate();
		
		assertEquals(opcionApuestaVicVisitanteCalculadoPorEvento.cuota(), opcionApuesta1VictoriaVisitante.cuota());
		assertEquals(opcionApuestaVicVisitanteCalculadoPorEvento.resultado().ganaCompetidor(), opcionApuesta1VictoriaVisitante.resultado().ganaCompetidor());

		
		assertEquals(opcionApuestaVicLocalCalculadoPorEvento.cuota(), opcionApuestaVictoriaLocal.cuota());
		assertEquals(opcionApuestaVicLocalCalculadoPorEvento.resultado().ganaCompetidor(), opcionApuestaVictoriaLocal.resultado().ganaCompetidor());
		
		
		
		/*
		ArrayList<OpcionApuesta> listaOpciones = new ArrayList<>();
		listaOpciones.add(opcionApuestaVicLocalCalculadoPorEvento);
		listaOpciones.add(opcionApuestaVicVisitanteCalculadoPorEvento);
		
		
		assertEquals(listaOpciones, evento.getOpcionesResultadosPosibles());
		*/
		
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
	

	@Test
	public void testCuandoUnPartidoFinalizaEventoRecibeNotificacionYPagaGananciasAUsuarios() throws Exception {
		
		// cuando finaliza un partido evento setea ganancias en apuestas
		// luego paga las ganancias a usuario
		// y por ultimo evento deja de estar disponible
		
		usuario.incrementarMontoWallet(400.00);
		estadoPartidoProximo.addApuesta(evento, usuario, opcionApuestaVictoriaLocal, 150.00, false);
		assertTrue(250.00 == usuario.getMontoWallet());
		when(mockPartido.getResultado()).thenReturn(resultadoVictoriaLocal);
		
		evento.updateFinalPartido();
		
		
		assertTrue(550.00 == usuario.getMontoWallet());
		assertFalse(evento.estaDisponible());
				
	}
	
	@Test
	public void testCuandoFinzalizaUnPartidoElEventoNotificaALosUsuariosQueHicieronApuestasSobreElPartido() {
		evento.updateInicioPartido();
		
		
	}
	
	@Test
	public void testSiUnUSuarioAcertoUnaAPuestaSeguraEventoCobraUnDescuentodel15PorcientoSobreGananciaNeta() throws Exception {
		
		usuario.incrementarMontoWallet(600.00);
		estadoPartidoProximo.addApuesta(evento, usuario, opcionApuestaVictoriaLocal, 100.00, true);
		assertTrue(500.00 == usuario.getMontoWallet());
		when(mockPartido.getResultado()).thenReturn(resultadoVictoriaLocal);
		
		evento.updateFinalPartido();
		
		
		assertTrue(685.00 == usuario.getMontoWallet());
		assertFalse(evento.estaDisponible());
		
	}
	@Test
	public void testCuandoUnUsuarioCancelaUnaApuestaSeguraConPartidoEnCursoEventoCobraPenalidadDel30porcientoApostado() throws Exception {
		
		
		usuario.incrementarMontoWallet(600.00);
	
		
		// usuario hace apuesta segura apostando 150 pesos
		estadoPartidoProximo.addApuesta(evento,usuario, opcionApuesta, 150.00, true);	
	
		//compruebo que ahora ya existe una apuesta en su historial
		assertEquals(1, usuario.getApuestasHechas().size());
		
		ApuestaSegura apuestaSeguraHecha = (ApuestaSegura) usuario.getApuestasHechas().get(0);
		
		
		estadoPartidoEnCurso.cancelarApuestaSegura(apuestaSeguraHecha);
		assertTrue(555.00 == usuario.getMontoWallet());
		
	}
	
	@Test
	public void testCuandoUnUsuarioCancelaUnaApuestaSeguraAntesDeComenzarPartidoEventoCobraPenalidadDe200pesos() throws Exception {
		
		
		usuario.incrementarMontoWallet(600.00);
	
		
		// usuario hace apuesta segura apostando 150 pesos
		estadoPartidoProximo.addApuesta(evento,usuario, opcionApuesta, 150.00, true);	
	
		//compruebo que ahora ya existe una apuesta en su historial
		assertEquals(1, usuario.getApuestasHechas().size());
		
		ApuestaSegura apuestaSeguraHecha = (ApuestaSegura) usuario.getApuestasHechas().get(0);
		
		
		estadoPartidoProximo.cancelarApuestaSegura(apuestaSeguraHecha);
		assertTrue(400.00 == usuario.getMontoWallet());
		
	}
	
	@Test
	public void testUnEventoRegistraApuestasRealizadas() {
		
		
		assertEquals(0, evento.getApuestasRealizadas().size());

		evento.registrarNuevaApuesta(mockApuestaFinal);
			
		//compruebo que ahora ya existe una apuesta 
		assertEquals(1, evento.getApuestasRealizadas().size());
		

	}
	
	
	
	
}
