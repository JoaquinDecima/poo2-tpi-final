package models.juego.estado;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.estado.*;

public class EnCursoTestCase {
	private EnCurso estado = new EnCurso();
	
	@Test
	public void testGetEstado() {
		assertEquals(estado.getEstado(), "En Curso");
	}

}
