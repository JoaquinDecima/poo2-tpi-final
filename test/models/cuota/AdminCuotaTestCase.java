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

package models.cuota;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import cuota.*;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidad;
import proveedores.*;
import proveedores.ProveedorDataPartido;

public class AdminCuotaTestCase {
	private Proveedor proveedor = mock(Proveedor.class);
	private AlgoritmoProbabilidad algoritmo = mock(AlgoritmoProbabilidad.class);
	private AdminCuota admin = new AdminCuota(proveedor, algoritmo);
	private Partido partido = mock(Partido.class);
	
	@Test
	public void testAdminCuotaHacePeticionProbabilidadVictoriaLocal() {
		algoritmo.getPosibilidadDeVictoriaLocal(partido, proveedor);
		
		verify(algoritmo).getPosibilidadDeVictoriaLocal(partido, proveedor);
	}
	
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeVictoriaVisitante() {
		admin.getCuotaPorVictoriaVisitante(partido);
		
		verify(algoritmo).getPosibilidadDeVictoriaVisitante(partido, proveedor);
	}
	
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeEmpate() {
		admin.getCuotaPorEmpate(partido);
		
		verify(algoritmo).getPosibilidadDeEmpate(partido, proveedor);
	}
	
	
	@Test
	public void suma1APosibilidadDeVictoriaLocal() {
		when(algoritmo.getPosibilidadDeVictoriaLocal(partido, proveedor)).thenReturn(0.3);
		
		assertEquals(admin.getCuotaPorVictoriaLocal(partido),1.7, 0.0);
	}
	
	
	@Test
	public void suma1APosibilidadDeVictoriaVisitante() {
		when(algoritmo.getPosibilidadDeVictoriaVisitante(partido, proveedor)).thenReturn(0.5);
		
		assertEquals(admin.getCuotaPorVictoriaVisitante(partido),1.5, 0.0);
	}
	
	
	@Test
	public void suma1APosibilidadDeEmpate() {
		when(algoritmo.getPosibilidadDeEmpate(partido, proveedor)).thenReturn(0.2);
		
		assertEquals(admin.getCuotaPorEmpate(partido),1.8, 0.0);
	}
}
