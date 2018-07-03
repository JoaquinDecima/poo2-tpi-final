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
	
	@SuppressWarnings("deprecation")
	private Date fecha = new Date(2018, 06, 23);
	private Date fecha2 = new Date(2018, 06, 23);
	
	private Deporte deporte1 = mock(Deporte.class);
	private Deporte deporte2 = mock(Deporte.class);
	
	private Competidor competidor1 = mock(Competidor.class);
	private Competidor competidor2 = mock(Competidor.class);
	
	private Partido partido1 = new Partido(competidor1, competidor2, deporte1, fecha, "Quilmes");;
	private Partido partido2 = new Partido(competidor1, competidor2, deporte2, fecha, "Chubut");;
	private Partido partido3 = new Partido(competidor2, competidor1, deporte1, fecha2, "Quilmes");;
	
	private Usuario usuario = new Usuario("diego", "diego@unq.edu.ar");
	
	private Usuario usuario1 = new Usuario("pato", "pato@unq.edu.ar");
	private Usuario usuario2 = new Usuario("sofia", "sofia@unq.edu.ar");
	private Usuario usuario3 = new Usuario("joaquin", "joaquin@unq.edu.ar");
	private Usuario usuario4 = new Usuario("leandro", "leandro@unq.edu.ar");
	private Usuario usuario5 = new Usuario("diego", "diego@unq.edu.ar");
	private Usuario usuario6 = new Usuario("facundo", "facundo@unq.edu.ar");
	private Usuario usuario7 = new Usuario("augusto", "augusto@unq.edu.ar");
	private Usuario usuario8 = new Usuario("pedro", "pedro@unq.edu.ar");
	
	private OpcionApuesta opcionApuesta1 = mock(OpcionApuesta.class);
	private OpcionApuesta opcionApuesta2 = mock(OpcionApuesta.class);
	
	private AdminCuota admin = casa.getAdminCuota();
	
	private Competidor local = mock(Competidor.class) ;
	private Competidor visitante = mock(Competidor.class);
	private Deporte deporte = mock(Deporte.class);
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
	
	 
	@Test
	public void testBalanceMensual() throws Throwable {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Se preparan respuestas partidos y Deportes
		when(deporte1.permiteEmpate()).thenReturn(false);
		when(deporte1.permiteEmpate()).thenReturn(true);
		
		// Se crean respuestas para algoritmos
		when(proveedor.cantDePartidosEntre(competidor1, competidor2)).thenReturn(10);
		when(proveedor.victoriasDeEnPartidos(competidor1, competidor2, 10)).thenReturn(4);
		when(proveedor.victoriasDeEnPartidos(competidor2, competidor1, 10)).thenReturn(4);
		when(proveedor.empatesDeEnPartidos(competidor1, competidor2, 10)).thenReturn(1);

		
		// SE Crean eventos
		Evento evento1 = casa.crearEventoDeportivo(partido1);
		Evento evento2 = casa.crearEventoDeportivo(partido2);
		Evento evento3 = casa.crearEventoDeportivo(partido3);
		
		// Se agregan apuestas al evento

		usuario1.hacerApuesta(evento2, opcionApuesta1, 200, false);
		usuario2.hacerApuesta(evento1, opcionApuesta2, 200, false);
		usuario3.hacerApuesta(evento2, opcionApuesta1, 200, false);
		usuario4.hacerApuesta(evento3, opcionApuesta2, 200, false);
		usuario5.hacerApuesta(evento3, opcionApuesta1, 200, false);
		usuario6.hacerApuesta(evento2, opcionApuesta2, 200, false);
		usuario7.hacerApuesta(evento1, opcionApuesta1, 200, false);
		usuario8.hacerApuesta(evento3, opcionApuesta2, 200, true);
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);
		usuarios.add(usuario6);
		usuarios.add(usuario7);
		usuarios.add(usuario8);
		
		assertEquals(casa.getUsuarios().size(), 8);
		assertEquals(casa.getApuestas().size(), 8);
	}

	
}
	
	