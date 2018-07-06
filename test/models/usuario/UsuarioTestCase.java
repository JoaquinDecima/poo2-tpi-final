/**
 *
 */
package models.usuario;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.estado.EnCurso;
import models.juego.estado.Finalizado;
import models.juego.estado.Proximo;
import models.juego.resultado.Resultado;
import models.juego.resultado.ResultadoConEmpate;


public class UsuarioTestCase {

	private Usuario usuario = new Usuario("diego", "diego@unq.edu.ar");
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
	private Date fecha;
	private Partido partido;
	private Resultado resultadoPosible = mock(ResultadoConEmpate.class);
	private AdminCuota adminCuota = mock(AdminCuota.class);
	private Evento evento;
	private OpcionApuesta opcionApuesta;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		fecha = new Date(2018, 06, 23);
		partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
		evento = new Evento(partido, adminCuota);
		opcionApuesta  = new OpcionApuesta(resultadoPosible, 10.00);	
	}


	@Test
	public void testCuandoUsuarioCancelaApuestaSeguraConPartidoEnCursoSePenalizaCobrando30porcientoApostado() {

		
		usuario.incrementarMontoWallet(200.00);
	
		usuario.hacerApuesta(evento, opcionApuesta, 150.00, true);

		// compruebo que ha quedado registrada en el evento la apuesta hecha
		assertEquals(1, evento.getApuestasUsuario(usuario).size(), 1);
		
		// usuario cancela apuesta segura con partido en curso
		partido.setEstado(new EnCurso());
		usuario.cancelarApuesta((ApuestaSegura) (evento.getApuestasUsuario(usuario)).get(0));
		
		// compruebo que usuario vuelve a poseer el dinero previo a la apuesta, con una quita del 30 porciento
		assertTrue(155.00 == usuario.getMontoWallet());
		
		// compruebo que se ha desactivado la apuesta
		assertFalse(((ApuestaSegura) evento.getApuestasUsuario(usuario).get(0)).estaActiva());

	}
	
	@Test
	public void testCuandoElPartidoHaComenzadoUsuarioYaNoPuedeHacerApuesta() {

		
		partido.setEstado(new EnCurso());
		usuario.incrementarMontoWallet(200.00);
		
		usuario.hacerApuesta(evento, opcionApuesta, 150.00, true);

	}


	@Test
	public void testEmailyNombre() {
		assertEquals(usuario.getEmail(), "diego@unq.edu.ar");
		usuario.setEmail("diego@gmail.com");
		assertEquals(usuario.getEmail(), "diego@gmail.com");
		assertEquals(usuario.getNombre(), "diego");
	}
	
	@Test
	public void testUpdates() {
		usuario.updateFinalPartido();
		usuario.updateInicioPartido();
	}
	
	@Test
	public void testCuandoUnUsuarioHaceUnaApuestaSeRegistraEnSuHistorialDeApuestas() {
		usuario.incrementarMontoWallet(300.00);
		// compruebo que el usuario no ha hecho apuestas
		assertEquals(0, usuario.getApuestasHechas().size());
		// usuario hace apuesta 
		usuario.hacerApuesta(evento, opcionApuesta, 150.00, true);
		// compruebo que se ha realizado una apuesta y se ha registrado
		assertEquals(1, usuario.getApuestasHechas().size());	
	}
	
	@Test
	public void testSiUsuarioHaceApuestaSeguraPuedeCancelarlaSiElPartidoNoComenzoySeCobraPenalidadDe200Pesos() {
		
		usuario.incrementarMontoWallet(600.00);
		//compruebo que el usuario no ha hecho una apuesta antes
		assertEquals(0, usuario.getApuestasHechas().size());
		
		partido.setEstado(new Proximo()); 
		
		// usuario hace apuesta segura apostando 150 pesos
		usuario.hacerApuesta(evento,opcionApuesta, 150.00, true);	
	
		//compruebo que ahora ya existe una apuesta en su historial
		assertEquals(1, usuario.getApuestasHechas().size());
		
		ApuestaSegura apuestaSeguraHecha = (ApuestaSegura) usuario.getApuestasHechas().get(0);
		
		// compruebo que la apuesta esta activa
		assertTrue(apuestaSeguraHecha.estaActiva());
		
		// cancelo la apuesta ya que es de tipo Segura
		usuario.cancelarApuesta(apuestaSeguraHecha);
		
		assertTrue(400.00 == usuario.getMontoWallet());
		assertFalse(apuestaSeguraHecha.estaActiva());
		
	}

	
	@Test 
	public void testPideMontoWallet() {
		assertEquals(usuario.getMontoWallet(), 0.0, 0.55);
	}
	
	@Test
	public void testSiUsuarioCanceloApuestaMientrasPartidoNoComenzoEntoncesPuedeReactivarlaSiSeArrepiente() {
		
		usuario.incrementarMontoWallet(600.00);
		//compruebo que el usuario no ha hecho una apuesta antes
		assertEquals(0, usuario.getApuestasHechas().size());
		
		partido.setEstado(new Proximo()); 
		
		// usuario hace apuesta segura apostando 150 pesos
		usuario.hacerApuesta(evento,opcionApuesta, 150.00, true);	
	
		//compruebo que ahora ya existe una apuesta en su historial
		assertEquals(1, usuario.getApuestasHechas().size());
		
		ApuestaSegura apuestaSeguraHecha = (ApuestaSegura) usuario.getApuestasHechas().get(0);
		
		// compruebo que la apuesta esta activa
		assertTrue(apuestaSeguraHecha.estaActiva());
		
		// cancelo la apuesta ya que es de tipo Segura
		usuario.cancelarApuesta(apuestaSeguraHecha);
		
		assertTrue(400.00 == usuario.getMontoWallet());
		assertFalse(apuestaSeguraHecha.estaActiva());
		
		usuario.reactivarApuesta(apuestaSeguraHecha);
		assertTrue(apuestaSeguraHecha.estaActiva());
	}	
	
	@Test
	public void testSiUsuarioCanceloApuestaConPartidoEnCursoEntoncesNoPuedeReactivarla() {
		
		usuario.incrementarMontoWallet(600.00);
		//compruebo que el usuario no ha hecho una apuesta antes
		assertEquals(0, usuario.getApuestasHechas().size());
		
		
		// usuario hace apuesta segura apostando 150 pesos
		usuario.hacerApuesta(evento,opcionApuesta, 150.00, true);	
		
	
		//compruebo que ahora ya existe una apuesta en su historial
		assertEquals(1, usuario.getApuestasHechas().size());
		
		ApuestaSegura apuestaSeguraHecha = (ApuestaSegura) usuario.getApuestasHechas().get(0);
		
		// compruebo que la apuesta esta activa
		assertTrue(apuestaSeguraHecha.estaActiva());
		
		partido.setEstado(new EnCurso()); 

		// cancelo la apuesta ya que es de tipo Segura
		usuario.cancelarApuesta(apuestaSeguraHecha);
		assertFalse(apuestaSeguraHecha.estaActiva());
		
		usuario.reactivarApuesta(apuestaSeguraHecha);
		assertFalse(apuestaSeguraHecha.estaActiva());
	}	

	@Test
	public void testUnUsuarioNoPuedeCancelarUnaApuestaSeguraSiElPartidoFinalizo() {
		
		usuario.incrementarMontoWallet(600.00);
		//compruebo que el usuario no ha hecho una apuesta antes
		assertEquals(0, usuario.getApuestasHechas().size());
		
		
		// usuario hace apuesta segura apostando 150 pesos
		usuario.hacerApuesta(evento,opcionApuesta, 150.00, true);	
		
	
		//compruebo que ahora ya existe una apuesta en su historial
		assertEquals(1, usuario.getApuestasHechas().size());
		
		ApuestaSegura apuestaSeguraHecha = (ApuestaSegura) usuario.getApuestasHechas().get(0);
		
		// compruebo que la apuesta esta activa
		assertTrue(apuestaSeguraHecha.estaActiva());
		
		partido.setEstado(new Finalizado()); 

		// cancelo la apuesta ya que es de tipo Segura
		usuario.cancelarApuesta(apuestaSeguraHecha);
		assertTrue(apuestaSeguraHecha.estaActiva());
		
	}	
	
	
}
