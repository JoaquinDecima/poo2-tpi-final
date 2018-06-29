package models.juego.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import juego.Partido;
import juego.estado.*;

public class EnCursoTestCase {
	private EnCurso estado = new EnCurso();
	private Partido partido = mock(Partido.class);
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "En Curso");
	}

	@Test
	public void testResultado() {
		estado.resultadoPartido(partido);
		verify(partido).getResultado();
	}
}
