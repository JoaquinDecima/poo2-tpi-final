package models.juego.resultado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import competidor.Competidor;
import juego.resultado.ResultadoSinEmpate;

public class ResultadoSinEmpateTestCase {
	private Competidor local = mock(Competidor.class);
	private Competidor visitante = mock(Competidor.class);
	private ResultadoSinEmpate resultado = new ResultadoSinEmpate(local, visitante);
	
	@Test
	public void test() {
		assertFalse(resultado.empate());
	}
	
	@Test
	public void testGanador() {
		assertEquals(resultado.ganaCompetidor(),local);
	}
	
	@Test
	public void testPerdedor() {
		assertEquals(resultado.pierdeCompetidor(),visitante);
	}
}
