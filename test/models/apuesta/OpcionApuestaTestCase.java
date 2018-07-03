package models.apuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.juego.resultado.ResultadoConEmpate;
import models.usuario.Usuario;

public class OpcionApuestaTestCase {
	
	private Partido mockPartido = mock(Partido.class);
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
	private Date fecha;
	private Partido partido;
	private Resultado resultado = mock(ResultadoConEmpate.class);
	private AdminCuota adminCuota = mock(AdminCuota.class);
	private Evento evento;
	private OpcionApuesta opcionApuesta;
	
	@Before
	public void setUp() {
		fecha = new Date(2018, 06, 23);
		partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
		evento = new Evento(mockPartido, adminCuota);
		opcionApuesta = new OpcionApuesta(resultado, 80.00);	
	}
	




	@Test
	public void testResultado() {
	
		assertEquals(opcionApuesta.resultado(), resultado);
	}

	@Test
	public void testCuota() {
		assertTrue(opcionApuesta.cuota() == 80.00);
	}

	@Test
	public void testRetornaPartido() {
		assertEquals(evento.getPartidoDelEvento(), mockPartido);
	}
	
	

}
