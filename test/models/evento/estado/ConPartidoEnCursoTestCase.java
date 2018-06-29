package models.evento.estado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

import apuesta.Apuesta;
import apuesta.opcion.OpcionApuesta;
import evento.Evento;
import evento.estado.ConPartidoEnCurso;
import usuario.Usuario;

public class ConPartidoEnCursoTestCase {
	private Evento evento = mock(Evento.class);
	private ConPartidoEnCurso estado = new ConPartidoEnCurso(evento);
	private ArrayList<Apuesta> lista = new ArrayList<Apuesta>();
	private OpcionApuesta opcionApuesta = mock(OpcionApuesta.class);
	private Usuario usuario = mock(Usuario.class);
	
	@Test
	public void test() {
		when(evento.getApuestasRealizadas()).thenReturn(lista);
		
		estado.addApuestaSegura(usuario, opcionApuesta, 260.50);
		assertEquals(lista.size(),1);
	}

}
