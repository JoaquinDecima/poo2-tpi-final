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

package models.proveedores;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;

// Importa desde org
import org.junit.Test;

import competidor.Competidor;
import deporte.Deporte;
import juego.Partido;
// Importa del Modelo
import proveedores.*;

public class ProveedorTestCase {
  private ProveedorDePartido partidos = mock(ProveedorDePartido.class);
  private ProveedorDeEstadistica estadistica = mock(ProveedorDeEstadistica.class);
  private Proveedor proveedor = new Proveedor(partidos, estadistica);
  
  private ArrayList<Partido> listapartidos = new ArrayList<Partido>();
  private ArrayList<Partido> listapartidos2 = new ArrayList<Partido>();
  private ArrayList<Partido> listapartidos3 = new ArrayList<Partido>();
  
  private Deporte deporte1 = mock(Deporte.class);
  
  private Competidor local = mock(Competidor.class);
  private Competidor visitante = mock(Competidor.class);
  
  private Date fecha = mock(Date.class);
  
  private Partido partido1 = mock(Partido.class);
  private Partido partido2 = mock(Partido.class);
  private Partido partido3 = mock(Partido.class);
  
	@Test
	public void testPideListaDeTodos() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		
		when(partidos.getPatridosAll()).thenReturn(listapartidos);
		
		assertEquals(proveedor.getPatridosAll(), listapartidos);
		verify(partidos).getPatridosAll();
	}
	
	@Test
	public void testPideListaDeDeporte() {
		listapartidos.add(partido1);
		listapartidos.add(partido3);
		
		when(partidos.getPartidosDeDeporte(deporte1)).thenReturn(listapartidos);
		
		assertEquals(proveedor.getPartidosDeDeporte(deporte1), listapartidos);
		verify(partidos).getPartidosDeDeporte(deporte1);
	}
	
	@Test
	public void testPartidosDeFecha() {
		listapartidos.add(partido1);
		
		when(partidos.getPartidosDeFecha(fecha)).thenReturn(listapartidos);
		
		assertEquals(proveedor.getPartidosDeFecha(fecha), listapartidos);
		verify(partidos).getPartidosDeFecha(fecha);
	}
	
	@Test
	public void testPartidosQueSeJueganEn() {
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		
		when(partidos.getPartidosQueSeJueguenEn("Quilmes")).thenReturn(listapartidos);
		
		assertEquals(proveedor.getPartidosQueSeJueguenEn("Quilmes"), listapartidos);
		verify(partidos).getPartidosQueSeJueguenEn("Quilmes");
	}
	
	@Test
	public void testVictoriasDeEnPartidos() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		listapartidos2.add(partido1);
		listapartidos2.add(partido2);
		
		when(partido1.juega(local)).thenReturn(true);
		when(partido2.juega(local)).thenReturn(true);
		when(partido3.juega(local)).thenReturn(true);
		when(partido1.juegan(local, visitante)).thenReturn(true);
		when(partido2.juegan(local, visitante)).thenReturn(true);
		when(partido3.juegan(local, visitante)).thenReturn(false);
		when(partidos.getPatridosAll()).thenReturn(listapartidos);
		when(estadistica.victoriasDe(local, 3, listapartidos)).thenReturn(2);
		when(estadistica.victoriasDe(local, 2, listapartidos2)).thenReturn(1);
		
		assertEquals(proveedor.victoriasDeEnPartidos(local, 3), 2);
		verify(estadistica).victoriasDe(local, 3, listapartidos);
		assertEquals(proveedor.victoriasDeEnPartidos(local, visitante, 2),1);
		verify(estadistica).victoriasDe(local, 2, listapartidos2);
	}
	
	@Test
	public void testPartidosDeDeportista() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		listapartidos2.add(partido1);
		listapartidos2.add(partido2);
		
		when(partido1.juega(local)).thenReturn(true);
		when(partido2.juega(local)).thenReturn(true);
		when(partido3.juega(local)).thenReturn(false);
		when(partidos.getPatridosAll()).thenReturn(listapartidos);
		
		assertEquals(proveedor.getPartidosDeDeportista(local), listapartidos2);
	}
	
	@Test
	public void testEmpatesDeEnPartidos() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		listapartidos2.add(partido1);
		listapartidos2.add(partido2);
		
		when(partido1.juega(local)).thenReturn(true);
		when(partido2.juega(local)).thenReturn(true);
		when(partido3.juega(local)).thenReturn(true);
		when(partido1.juegan(local, visitante)).thenReturn(true);
		when(partido2.juegan(local, visitante)).thenReturn(true);
		when(partido3.juegan(local, visitante)).thenReturn(false);
		when(partidos.getPatridosAll()).thenReturn(listapartidos);
		when(estadistica.empatesDe(listapartidos, 3)).thenReturn(2);
		when(estadistica.empatesDe(listapartidos2, 2)).thenReturn(1);
		
		assertEquals(proveedor.empatesDeEnPartidos(local, 3), 2);
		verify(estadistica).empatesDe(listapartidos, 3);
		assertEquals(proveedor.empatesDeEnPartidos(local, visitante, 2),1);
		verify(estadistica).empatesDe(listapartidos2, 2);
	}
	
	@Test
	public void testCantidadDePartidosEntre() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		
		when(partido1.juegan(local, visitante)).thenReturn(true);
		when(partido2.juegan(local, visitante)).thenReturn(true);
		when(partido3.juegan(local, visitante)).thenReturn(false);
		when(partidos.getPatridosAll()).thenReturn(listapartidos);
		
		assertEquals(proveedor.cantDePartidosEntre(local, visitante), 2);
	}
	
	@Test
	public void testPartidosDeDeportistas() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		listapartidos2.add(partido1);
		listapartidos2.add(partido3);
		
		when(partido1.juegan(local, visitante)).thenReturn(true);
		when(partido2.juegan(local, visitante)).thenReturn(false);
		when(partido3.juegan(local, visitante)).thenReturn(true);
		when(partidos.getPatridosAll()).thenReturn(listapartidos);
		
		assertEquals(proveedor.getPartidosDeDeportistas(local, visitante), listapartidos2);
	}
	
	@Test
	public void testORLogico() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos2.add(partido1);
		listapartidos2.add(partido3);
		listapartidos3.add(partido1);
		listapartidos3.add(partido2);
		listapartidos3.add(partido3);
		
		assertEquals(proveedor.logicOR(listapartidos, listapartidos2), listapartidos3);
	}
	
	@Test
	public void testANDLogico() {
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		listapartidos2.add(partido1);
		listapartidos2.add(partido3);
		listapartidos3.add(partido3);
		
		assertEquals(proveedor.logicAND(listapartidos, listapartidos2), listapartidos3);
	}
}
