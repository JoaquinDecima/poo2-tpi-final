package models.apuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import models.apuesta.opcion.OpcionApuesta;
import models.juego.resultado.Resultado;

public class OpcionApuestaTestCase {
	private Resultado resultado = mock(Resultado.class);
	private OpcionApuesta opcion = new OpcionApuesta(resultado, 200.3);
	
	@Test
	public void testResultado() {
		assertEquals(opcion.resultado(), resultado);
	}
	
	@Test
	public void testCuota() {
		assertEquals(opcion.cuota(), 200.3, 0.5);
	}
}
