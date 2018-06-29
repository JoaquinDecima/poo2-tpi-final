package models.evento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cuota.AdminCuota;
import evento.Evento;
import juego.Partido;
import juego.estado.EnCurso;
import proveedores.Proveedor;
import usuario.Usuario;
import apuesta.Apuesta;
import apuesta.OpcionApuesta;
import casaApuesta.CasaApuesta;

public class EventoTestCase {
	
	
	private Usuario usuario;
	private AdminCuota adminCuota;
	private OpcionApuesta opcionApuesta;
	private Partido mockPartido;
	private Evento evento;
	
	@Before
	void setUp() {
		adminCuota = mock(AdminCuota.class);
		mockPartido = mock(Partido.class);
		evento = new Evento(mockPartido, adminCuota);
		opcionApuesta = mock(OpcionApuesta.class);
		
		
		
		
		
		
	}
	
	
	
	@Test
	public void testPartido() {
		assertEquals(evento.getPartidoDelEvento(), mockPartido);
	}
	
	@Test
	public void testApuestaPosibles() {
		// TODO: Corregir implementacion
		assertEquals(evento.getOpcionesResultadosPosibles(),null);
	}
	
	@Test
	public void testResultado() {
		evento.getResultadoPartido();
		verify(mockPartido).getResultado();
	}
	
	@Test
	public void testApuestaRealizadas() {
		assertEquals(evento.getApuestasRealizadas(), new ArrayList<Apuesta>());
	}
	
	
}
