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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

// Importa desde org
import org.junit.Test;

import competidor.Competidor;
import juego.Partido;
import proveedores.ProveedorDeEstadistica;

public class ProveedorDeEstadisticaTestCase {
	private ProveedorDeEstadistica estadistica = new ProveedorDeEstadistica();
	private Competidor local = mock(Competidor.class);
	
	private ArrayList<Partido> listapartidos = new ArrayList<Partido>();
	private ArrayList<Partido> listapartidos2 = new ArrayList<Partido>();
	
	private Partido partido1 = mock(Partido.class);
	private Partido partido2 = mock(Partido.class);
	private Partido partido3 = mock(Partido.class);
	  
	@Test
	public void testVictoriasDe() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		
		when(partido1.esLocal(local)).thenReturn(true);
		when(partido2.esLocal(local)).thenReturn(true);
		when(partido3.esLocal(local)).thenReturn(false);
		when(partido1.ganaLocal()).thenReturn(true);
		when(partido2.ganaLocal()).thenReturn(false);
		when(partido3.ganaLocal()).thenReturn(true);
		when(partido1.esVisitante(local)).thenReturn(false);
		when(partido2.esVisitante(local)).thenReturn(false);
		when(partido3.esVisitante(local)).thenReturn(true);
		when(partido1.ganaVisitante()).thenReturn(false);
		when(partido2.ganaVisitante()).thenReturn(false);
		when(partido3.ganaVisitante()).thenReturn(false);
		
		assertEquals(estadistica.victoriasDe(local, 3, listapartidos), 1);
	}
	
	@Test
	public void testEmpatesDe() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);

		when(partido1.huboEmpate()).thenReturn(true);
		when(partido2.huboEmpate()).thenReturn(false);
		when(partido3.huboEmpate()).thenReturn(true);
		
		assertEquals(estadistica.empatesDe(listapartidos, 3), 2);
	}

	@Test
	public void testPrimeros() {
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		listapartidos2.add(partido1);
		listapartidos2.add(partido2);
		
		assertEquals(estadistica.getPrimeros(2, listapartidos), listapartidos2);
	}
}
