package models.juego.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import models.juego.Partido;
import models.juego.resultado.ResultadoNull;

public class ProximoTestCase {
	
	private Proximo estado = new Proximo();
	private Partido partido = mock(Partido.class);
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "Proximo");
	}

	@Test
	public void testCuandoSePideElResultadoDelPartidoSinQueHayaComenzadoSeObtieneResultadoNull() {
		assertTrue(estado.resultadoPartido(partido) instanceof ResultadoNull);
	}
}
