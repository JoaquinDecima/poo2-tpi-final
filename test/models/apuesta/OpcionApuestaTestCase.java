package models.apuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import apuesta.OpcionApuesta;
import juego.Partido;
import juego.resultado.Resultado;

public class OpcionApuestaTestCase {
	private Partido mockPartido = mock(Partido.class);
	private Resultado resultado = mock(Resultado.class);
	private OpcionApuesta opcion = new OpcionApuesta(mockPartido, resultado, 200.3);

	
	@Test
	public void testResultado() {
		assertEquals(opcion.resultado(), resultado);
	}
	
	@Test
	public void testCuota() {
		assertEquals(opcion.cuota(), 200.3, 0.5);
	}
	
	@Test
	public void testRetornaPartido() {
		assertEquals(opcion.getPartido(), mockPartido);
	}
	
	
}
