/*
 * Programacion Orientada a Objetos II 2018 s1
 * Universidad Nacional de Quilmes
 *
 * Casa de Apuestas HITO 1
 *
 * Alumnos:
 *        Decima, Joaquin A. (Pato)
 *        Otarola, Florencia
 */

package models.apuesta;

// Import Static
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Importa desde org
import org.junit.Test;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public class ApuestaSeguraTestCase {
	private Usuario usuario = mock(Usuario.class);
	private Evento evento = mock(Evento.class);
	private OpcionApuesta opcionApuesta = mock(OpcionApuesta.class);
	private ApuestaSegura apuesta = new ApuestaSegura(usuario, evento, opcionApuesta, 260.0);

	@Test
	public void testMonto() {
		assertEquals(apuesta.montoApostado(),260.0,0.5);
	}

	@Test
	public void testOpcionApuesta() {
		assertEquals(apuesta.opcionApostada(), opcionApuesta);
	}
	
	@Test
	public void testActiva() {
		assertTrue(apuesta.estaActiva());
	}
	
	@Test
	public void testCambioEstado() {
		assertTrue(apuesta.estaActiva());
		
		apuesta.updateEstado();
		
		assertTrue(!apuesta.estaActiva());
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
}
