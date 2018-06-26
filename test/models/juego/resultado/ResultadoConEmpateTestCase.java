package models.juego.resultado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import competidor.Competidor;
import juego.resultado.ResultadoConEmpate;

public class ResultadoConEmpateTestCase {
	private Competidor local = mock(Competidor.class);
	private Competidor visitante = mock(Competidor.class);
	private ResultadoConEmpate resultadoEmpato = new ResultadoConEmpate(local, visitante, true);
	private ResultadoConEmpate resultadoNoEmpato = new ResultadoConEmpate(local, visitante, false);
	
	@Test
	public void testConEmpte() {
		assertTrue(resultadoEmpato.empate());
		assertTrue(!resultadoNoEmpato.empate());
	}
	
	@Test
	public void testGanador() {
		assertEquals(resultadoEmpato.ganaCompetidor(),local);
	}
	
	@Test
	public void testPerdedor() {
		assertEquals(resultadoEmpato.pierdeCompetidor(),visitante);
	}
}
