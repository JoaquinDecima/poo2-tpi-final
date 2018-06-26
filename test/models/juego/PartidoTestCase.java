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
import static org.mockito.Mockito.when;

// Importa utilidades Java
import java.util.Date;

// Importa desde org
import org.junit.Test;

import competidor.Competidor;
import deporte.Deporte;
import juego.Partido;
import juego.resultado.Resultado;

public class PartidoTestCase {
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Competidor otroEquipo = mock(Competidor.class);
	
	private Deporte deporte = mock(Deporte.class);
	private Date fecha = new Date(2018, 06, 23); // Se crea para tener la fecha
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
	
	private Resultado resultado = mock(Resultado.class);

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
		
		assertFalse(partido.juega(otroEquipo));
		assertFalse(partido.juegan(local, otroEquipo));
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
		
		when(resultado.empate()).thenReturn(true);
		assertTrue(partido.huboEmpate());
		
		when(resultado.empate()).thenReturn(false);
		assertFalse(partido.huboEmpate());
	}
}
