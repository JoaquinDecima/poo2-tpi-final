package models.juego.resultado;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultadoNullTestCase {
	private ResultadoNull resultado = new ResultadoNull();
	
	@Test
	public void testEmpate() {
		assertFalse(resultado.empate());
	}

}
