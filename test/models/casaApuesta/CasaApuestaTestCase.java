package models.casaApuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import models.apuesta.opcion.OpcionApuesta;
import models.casaApuesta.CasaApuesta;
import models.competidor.Competidor;
import models.cuota.AdminCuota;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.juego.resultado.ResultadoConEmpate;
import models.probabilidad.AlgoritmoProbabilidad;
import models.proveedores.Proveedor;
import models.usuario.Usuario;

public class CasaApuestaTestCase {

	private Proveedor proveedor = mock(Proveedor.class);
	private AlgoritmoProbabilidad algoritmo = mock(AlgoritmoProbabilidad.class);
	private AlgoritmoProbabilidad algoritmo2 = mock(AlgoritmoProbabilidad.class);
	
	private CasaApuesta casa = new CasaApuesta(proveedor, algoritmo);
	
	private Partido partido1 = mock(Partido.class);
	private Partido partido2 = mock(Partido.class);
	private Partido partido3 = mock(Partido.class);
	
	private Usuario usuario = new Usuario("diego", "diego@unq.edu.ar");
	
	private Usuario usuario1 = mock(Usuario.class);
	private Usuario usuario2 = mock(Usuario.class);
	private Usuario usuario3 = mock(Usuario.class);
	private Usuario usuario4 = mock(Usuario.class);
	private Usuario usuario5 = mock(Usuario.class);
	private Usuario usuario6 = mock(Usuario.class);
	private Usuario usuario7 = mock(Usuario.class);
	private Usuario usuario8 = mock(Usuario.class);
	
	private Deporte deporte1 = mock(Deporte.class);
	private Deporte deporte2 = mock(Deporte.class);
	
	private Competidor competidor1 = mock(Competidor.class);
	private Competidor competidor2 = mock(Competidor.class);
	
	private OpcionApuesta opcionApuesta1 = mock(OpcionApuesta.class);
	private OpcionApuesta opcionApuesta2 = mock(OpcionApuesta.class);
	
	private AdminCuota admin = casa.getAdminCuota();
	
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
	private Date fecha = new Date(2018, 06, 23);
	private Partido partido = new Partido(local, visitante, deporte, fecha, "Quilmes");
	private Resultado resultadoPosible = mock(ResultadoConEmpate.class);
	private Evento evento = casa.crearEventoDeportivo(partido);
	private OpcionApuesta opcionApuesta = new OpcionApuesta(resultadoPosible, 10.00);

	
	
	
	@Test
	public void testGetAdminCuota() {
		assertEquals(casa.getAdminCuota(), admin);
	}
	
	@Test
	public void testSetAlgoritmo() {
		assertEquals(casa.getAlgoritmoProbabilidad(), algoritmo);
		casa.setAlgoritmoProbabilidad(algoritmo2);
		assertEquals(casa.getAlgoritmoProbabilidad(), algoritmo2);
	}
	
	@Test
	public void testGetUsuarios() throws Throwable {

		assertEquals(0, casa.getUsuarios().size());

		assertEquals(0, casa.getApuestas().size());
		
		usuario.hacerApuesta(evento, opcionApuesta, 10.00, true);
		usuario.hacerApuesta(evento, opcionApuesta, 20.00, false);
					
		
		assertEquals(2, casa.getApuestas().size());
		
		assertEquals(1, casa.getUsuarios().size());
	}
	
	@Test
	public void testGetApuestas() throws Exception{
		
		assertEquals(casa.getApuestas().size(), 0);
		
		usuario.hacerApuesta(evento, opcionApuesta, 10.00, true);
		usuario.hacerApuesta(evento, opcionApuesta, 20.00, false);
					
		assertEquals(2, casa.getApuestas().size());
	}
	
	/*
	 * TODO: Un test a corregir
	 
	@Test
	public void testBalanceMensual() throws Throwable {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Se preparan respuestas partidos y Deportes
		when(partido1.getDeporte()).thenReturn(deporte1);
		when(partido2.getDeporte()).thenReturn(deporte1);
		when(partido3.getDeporte()).thenReturn(deporte2);
		when(deporte1.permiteEmpate()).thenReturn(false);
		when(deporte1.permiteEmpate()).thenReturn(true);
		
		// Se crean respuestas para algoritmos
		when(partido1.getLocal()).thenReturn(competidor1);
		when(partido1.getVisitante()).thenReturn(competidor2);
		when(partido2.getLocal()).thenReturn(competidor1);
		when(partido2.getVisitante()).thenReturn(competidor2);
		when(partido3.getLocal()).thenReturn(competidor1);
		when(partido3.getVisitante()).thenReturn(competidor2);
		when(proveedor.cantDePartidosEntre(competidor1, competidor2)).thenReturn(10);
		when(proveedor.victoriasDeEnPartidos(competidor1, competidor2, 10)).thenReturn(4);
		when(proveedor.victoriasDeEnPartidos(competidor2, competidor1, 10)).thenReturn(4);
		when(proveedor.empatesDeEnPartidos(competidor1, competidor2, 10)).thenReturn(1);
		
		// Se crean Respuestas para Balance
		when(usuario1.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario2.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario3.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario4.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario5.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario6.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario7.getEmail()).thenReturn("pato@latinlinux.com");
		when(usuario8.getEmail()).thenReturn("pato@latinlinux.com");
		when(partido1.getFechaDate()).thenReturn(new Date());
		when(partido2.getFechaDate()).thenReturn(new Date());
		when(partido3.getFechaDate()).thenReturn(new Date());
		
		// SE Crean eventos
		Evento evento1 = casa.crearEventoDeportivo(partido1);
		Evento evento2 = casa.crearEventoDeportivo(partido2);
		Evento evento3 = casa.crearEventoDeportivo(partido3);
		
		// Se agregan apuestas al evento
		
		partido1.addApuesta(evento1, usuario2, opcionApuesta2, 200.0, false);
		partido2.addApuesta(evento2, usuario3, opcionApuesta1, 200.0, false);
		partido2.addApuesta(evento2, usuario1, opcionApuesta1, 200.0, false);
		partido3.addApuesta(evento3, usuario4, opcionApuesta2, 200.0, false);
		partido3.addApuesta(evento3, usuario5, opcionApuesta1, 200.0, false);
		partido2.addApuesta(evento2, usuario6, opcionApuesta2, 200.0, false);
		partido1.addApuesta(evento1, usuario7, opcionApuesta1, 200.0, false);
		partido3.addApuesta(evento3, usuario8, opcionApuesta2, 200.0, true);
		
		
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);
		usuarios.add(usuario6);
		usuarios.add(usuario7);
		usuarios.add(usuario8);
		
		assertEquals(casa.getUsuarios(), usuarios);
		assertEquals(casa.getUsuarios().size(), 8);
		assertEquals(casa.getApuestas().size(), 8);
		
		casa.balanceMensual();
	}
	*/
	
}
	
	