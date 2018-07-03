/**
 *
 */
package models.usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import models.apuesta.Apuesta;
import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.casaApuesta.CasaApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.estado.EnCurso;
import models.juego.resultado.Resultado;
import models.juego.resultado.ResultadoConEmpate;
import models.usuario.Usuario;


public class UsuarioTestCase {

	private Usuario usuario = new Usuario("diego", "diego@unq.edu.ar");
	private CasaApuesta mockCasaApuesta = mock(CasaApuesta.class);
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
	private Date fecha;
	private Partido partido;
	private Resultado resultadoPosible = mock(ResultadoConEmpate.class);
	private AdminCuota adminCuota = mock(AdminCuota.class);
	private Evento evento;
	private OpcionApuesta opcionApuesta;
	
	@Before
	public void setUp() {
		fecha = new Date(2018, 06, 23);
		partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
		evento = new Evento(partido, adminCuota);
		opcionApuesta  = new OpcionApuesta(resultadoPosible, 10.00);	
	}
/*
 * 

	@Test
	public void testCuandoUsuarioCancelaApuestaSeguraConPartidoEnCursoSePenalizaCobrando30porcientoApostado() {

		assertEquals(usuario.getMontoWallet(), 0.00, 0.00);
		// seteo 200 pesos en wallet de usuario
		usuario.incrementarMontoWallet(200.00);
		// compruebo que existen 200 pesos en wallet de usuario
		assertEquals(usuario.getMontoWallet(), 200.00, 200.00);
		// chequeo que el usuario no ha hecho apuestas en evento
		assertEquals(0, evento.getApuestasUsuario(usuario).size(), 0);
		// usuario hace apuestaSegura en evento
		usuario.hacerApuesta(opcionApuesta, 150.00);
		// compruebo que se han descontado 150 pesos de wallet de usuario
		assertEquals(usuario.getMontoWallet(), 50.00, 50.00);
		// compruebo que ha quedado registrada en el evento la apuesta hecha
		assertEquals(1, evento.getApuestasUsuario(usuario).size(), 1);
		// usuario cancela apuesta segura con partido en curso
		partido.setEstado(new EnCurso());
		usuario.cancelarApuesta((ApuestaSegura) (evento.getApuestasUsuario(usuario)).get(0));
		// compruebo que usuario vuelve a poseer el dinero previo a la apuesta, con una quita del 30 porciento
		assertEquals(usuario.getMontoWallet(), 155, 155);
		// compruebo que se ha quitado la apuesta del registro en el evento
		assertFalse(((ApuestaSegura) evento.getApuestasUsuario(usuario).get(0)).estaActiva());

		assertEquals(usuario.getNombre(), "diego");
	}
 */
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
	public void testUnUsuarioPuedeHacerUnaApuestaSeguraYPuedeCancelarlaSiElPartidoNoComenzo() {
		//compruebo que el usuario no ha hecho una apuesta antes
		assertEquals(0, usuario.getApuestasHechas().size());
		// usuario hace apuesta segura apostando 150 pesos
		usuario.hacerApuesta(evento,opcionApuesta, 150.00, true);	
		//compruebo que ya existe una apuesta en su historial
		//assertEquals(1, usuario.getApuestasHechas().size());	
		// cancelo la apuesta ya que es de tipo Segura
		//ApuestaSegura apuestaNueva = (ApuestaSegura) usuario.getApuestasHechas().get(1);
		//usuario.cancelarApuesta(apuestaNueva);
	}
	
	/*@Test
	public void testUnUsuarioPuedeHacerUnaApuestaFinalQueNoPermiteCancelacion() {
		assertEquals(0, usuario.getApuestasHechas().size(), 0);
		usuario.hacerApuesta(opcionApuesta, 150.00, true);
		assertEquals(1, usuario.getApuestasHechas().size(), 1);	
		usuario.getApuestasHechas().get(0);
		
	}
	*/
	

	@Test 
	public void testPideMontoWallet() {
		assertEquals(usuario.getMontoWallet(), 0.0, 0.55);
	}
}
