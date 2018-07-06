package models.juego.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import models.apuesta.ApuestaSegura;
import models.juego.Partido;
import models.juego.resultado.Resultado;

public class EnCursoTestCase {
	private EnCurso estado = new EnCurso();
	private Partido partido = mock(Partido.class);
	private Resultado mockResultado = mock(Resultado.class);
	private ApuestaSegura apuesta = mock(ApuestaSegura.class);
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "En Curso");
	}

	@Test
	public void testElEstadoEnCursoSabeRetornarElResultadoActualDelPartido() {
			
		when(partido.resultado()).thenReturn(mockResultado);
		assertEquals(partido.resultado(), estado.resultadoPartido(partido));
	}
	
	@Test
	public void testResultado() {
		estado.resultadoPartido(partido);
		verify(partido).resultado();
	}
	
	@Test(expected=Exception.class)
	public void testMovimientoApuesta() throws Exception {
		estado.reactivarApuestaSegura(apuesta);
	}
}
