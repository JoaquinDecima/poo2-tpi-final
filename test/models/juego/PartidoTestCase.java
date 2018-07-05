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
import static org.mockito.Mockito.*;

// Importa utilidades Java
import java.util.Date;

// Importa desde org
import org.junit.Test;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.ISubscriptorPartido;
import models.juego.Partido;
import models.juego.estado.EnCurso;
import models.juego.estado.EstadoPartido;
import models.juego.estado.Finalizado;
import models.juego.resultado.Resultado;
import models.juego.resultado.ResultadoConEmpate;
import models.usuario.Usuario;

public class PartidoTestCase {
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Competidor otroEquipo = mock(Competidor.class);

	private Deporte deporte = mock(Deporte.class);
	@SuppressWarnings("deprecation")
	private Date fecha = new Date(2018, 06, 23); // Se crea para tener la fecha
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
	private Usuario usuario = new Usuario("diego", "diego@unq.edu.ar");
	private Resultado resultado = mock(ResultadoConEmpate.class);
	private EstadoPartido estado = mock(EstadoPartido.class);
	private Evento mockEvento = mock(Evento.class);
	private OpcionApuesta opcionApuesta = new OpcionApuesta(resultado, 100.00);
	private AdminCuota mockAdminCuota = mock(AdminCuota.class);
	private Evento evento = new Evento(partido, mockAdminCuota);
	
	private ApuestaSegura apuesta = mock(ApuestaSegura.class);
	
	private ISubscriptorPartido subscriptor = mock(ISubscriptorPartido.class);

	@Test
	public void testPartidoDevuelveLocal() {
		assertEquals(partido.getLocal(), this.local);
	}
	
	@Test(expected = Exception.class) 
	public void testCuandoUsuarioSolicitaHacerApuestaSeguraConPartidoEnCursoSeLanzaExcepcion(){
		partido.setEstado(new EnCurso());
		usuario.hacerApuesta(evento, opcionApuesta, 20.00, false); 
	}

	@Test
	public void testPartidoDevuelveVisitante() {
		assertEquals(partido.getVisitante(), this.visitante);
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testPartidoDevuelveFechaDeJuego() {
		assertEquals(partido.getFecha().getDate(), this.fecha.getDate());
	}

	@Test
	public void testPartidoPreguntaJuega() {
		assertTrue(partido.juega(local));
		assertTrue(partido.juega(visitante));
		assertTrue(partido.juegan(local, visitante));
		assertTrue(partido.juegan(visitante, local));

		assertFalse(partido.juega(otroEquipo));
		assertFalse(partido.juegan(local, otroEquipo));
		assertFalse(partido.juegan(otroEquipo, local));
		assertFalse(partido.juegan(otroEquipo, otroEquipo));
		assertFalse(partido.juegan(local, local));
		assertFalse(partido.juegan(visitante, otroEquipo));
		assertFalse(partido.juegan(otroEquipo, visitante));
		assertFalse(partido.juegan(visitante, visitante));

	}

	@Test
	public void testPartidoRetornaLugar() {
		assertEquals(partido.getLugarDeJuego(), "Quilmes");
	}

	@Test
	public void testPartidoPreguntaDeporte() {
		when(deporte.esDeporte(deporte)).thenReturn(true);

		assertTrue(partido.esDeporte(deporte));
		assertEquals(partido.getDeporte(), deporte);
	}

	@Test
	public void testPartidoPreguntaEsLocal() {
		assertTrue(partido.esLocal(local));
		assertTrue(!partido.esLocal(visitante));
	}

	@Test
	public void testPartidoPreguntaEsVisitante() {
		assertTrue(!partido.esVisitante(local));
		assertTrue(partido.esVisitante(visitante));
	}

	@Test
	public void testGetYSetResultado() {
		partido.setResultado(resultado);
		partido.setEstado(estado);

		when(estado.resultadoPartido(partido)).thenReturn(resultado);

		assertEquals(partido.getResultado(), resultado);
	}

	@Test
	public void testGanaLocal() {
		partido.setResultado(resultado);

		when(resultado.ganaCompetidor()).thenReturn(local);
		assertTrue(partido.ganaLocal());

		when(resultado.ganaCompetidor()).thenReturn(visitante);
		assertFalse(partido.ganaLocal());
	}

	@Test
	public void testGanaVisitante() {
		partido.setResultado(resultado);

		when(resultado.ganaCompetidor()).thenReturn(visitante);
		assertTrue(partido.ganaVisitante());

		when(resultado.ganaCompetidor()).thenReturn(local);
		assertFalse(partido.ganaVisitante());
	}

	
	@Test
	public void testHuboEmpate() {
		partido.setResultado(resultado);
		partido.setEstado(new Finalizado());

		when(resultado.empate()).thenReturn(true);
		assertTrue(partido.huboEmpate());
		
		when(resultado.empate()).thenReturn(false);
		assertFalse(partido.huboEmpate());
		partido.notificarFinalSubscriptores();
		partido.notificarInicioSubscriptores();
	}

	
	@Test
	public void testGetFechaDate() {
		assertEquals(partido.getFechaDate(), this.fecha);
	}

	@Test
	public void testSuscriptores() {
		assertEquals(partido.getSubscriptores().size(), 0);
		partido.addSubscriptor(subscriptor);
		assertEquals(partido.getSubscriptores().size(), 1);

		partido.notificarFinalSubscriptores();
	}
	

	@Test
	public void testUnPartidoPuedeAndirSubscriptores() {
		partido.addSubscriptor(mockEvento);
		assertTrue((partido.getSubscriptores().contains(mockEvento)));
	}
	
	@Test
	public void testCancelarYReactivarApuestaSegura() throws Exception {
		when(apuesta.getEvento()).thenReturn(evento);
		when(apuesta.getUsuario()).thenReturn(usuario);
		
		partido.cancelarApuestaSegura(apuesta);
		partido.reactivarApuestaSegura(apuesta);
	}
}
