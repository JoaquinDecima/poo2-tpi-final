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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

// Importa utilidades Java
import java.util.Date;

// Importa desde org
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.asm.tree.analysis.AnalyzerException;

import apuesta.OpcionApuesta;
import competidor.Competidor;
import deporte.Deporte;
import evento.Evento;
import juego.Partido;
import juego.estado.EnCurso;
import juego.estado.Finalizado;
import juego.resultado.Resultado;
import usuario.Usuario;

public class PartidoTestCase {
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Evento mockEvento = mock(Evento.class);
	
	private Deporte deporte = mock(Deporte.class);
	private Date fecha = new Date(2018, 06, 23); // Se crea para tener la fecha
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
	private Usuario usuario = mock(Usuario.class);
	private Resultado resultado = mock(Resultado.class);
	private OpcionApuesta mockOpcionApuesta = mock(OpcionApuesta.class);

	@Test
	public void testPartidoDevuelveLocal() {
		assertEquals(partido.getLocal(), this.local);
	}

	@Test
	public void testPartidoDevuelveVisitante() {
		assertEquals(partido.getVisitante(), this.visitante);
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testPartidoDevuelveFechaDeJuego() {
		assertEquals(partido.getFecha(), this.fecha.getDate());
	}

	@Test
	public void testPartidoPreguntaJuega() {
		assertTrue(partido.juega(local));
		assertTrue(partido.juega(visitante));
		assertTrue(partido.juegan(local, visitante));
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
	public void testCuandoUsuarioSolicitaHacerApuestaSeguraConPartidoEnCursoSeLanzaExcepcion() {	
		partido.setEstado(new EnCurso());
		usuario.hacerApuestaSegura(mockOpcionApuesta, 20);
		//TODO:verificar excepcion??
	}
	
	@Test
	public void testUnPartidoPuedeAñadirSubscriptores() {	
		partido.addSubscriptor(mockEvento);
		verify((partido.getSubscriptores()).contains(mockEvento));
	}
	
	
	
	
}
