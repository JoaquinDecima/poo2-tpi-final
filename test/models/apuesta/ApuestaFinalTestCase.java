package models.apuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Test;

import models.apuesta.ApuestaFinal;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.usuario.Usuario;

public class ApuestaFinalTestCase {
	private Usuario usuario = mock(Usuario.class);
	private Evento evento = mock(Evento.class);
	private OpcionApuesta opcionApuesta = mock(OpcionApuesta.class);
	private ApuestaFinal apuesta = new ApuestaFinal(evento, usuario, opcionApuesta, 260.0);
	private Date fecha = new Date();
	private Resultado resultado = mock(Resultado.class);
	private Partido partido = mock(Partido.class);
	
	@Test
	public void testMonto() {
		assertEquals(apuesta.montoApostado(),260.0,0.5);
	}

	@Test
	public void testOpcionApuesta() {
		assertEquals(apuesta.opcionApostada(), opcionApuesta);
	}
	
	@Test
	public void testEvento() {
		assertEquals(apuesta.getEvento(), evento);
	}
	
	@Test
	public void testUsuario() {
		assertEquals(apuesta.getUsuario(), usuario);
	}
	
	@Test
	public void testPartido() {
		apuesta.getPartido();
		verify(evento).getPartidoDelEvento();
	}
	
	@Test
	public void testFecha() {
		when(evento.getFecha()).thenReturn(fecha);
		assertEquals(apuesta.getFecha(), fecha);
	}
	
	@Test
	public void testCalcularGanacias() {
		when(opcionApuesta.cuota()).thenReturn(1.5);
		when(partido.getResultado()).thenReturn(resultado);
		when(opcionApuesta.resultado()).thenReturn(resultado);
		when(evento.getPartidoDelEvento()).thenReturn(partido);
		
		apuesta.calcularGanancias();
		
		assertEquals(apuesta.gananciaBruta(), 390.0, 0.55);
		assertEquals(apuesta.gananciaNeta(), 130.0, 0.55);
	}
}
