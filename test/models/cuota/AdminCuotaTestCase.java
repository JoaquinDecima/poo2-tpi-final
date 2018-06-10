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

import models.juego.Partido;
import models.probabilidad.AlgoritmoProbabilidad;
import models.proveedores.Proveedor;

public class AdminCuotaTestCase {
	private Proveedor proveedor = mock(Proveedor.class);
	private AlgoritmoProbabilidad algoritmo = mock(AlgoritmoProbabilidad.class);
	private AdminCuota admin= new AdminCuota(proveedor, algoritmo);
	private Partido partido = mock(Partido.class);
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeVictoriaLocal() {
		admin.getCuotaDeVictoriaLocal(partido);
		
		verify(algoritmo).getPosibilidadDeVictoriaLocal(partido, proveedor);
	}
	
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeVictoriaVisitante() {
		admin.getCuotaDeVictoriaVisitante(partido);
		
		verify(algoritmo).getPosibilidadDeVictoriaVisitante(partido, proveedor);
	}
	
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeEmpate() {
		admin.getCuotaDeEmpate(partido);
		
		verify(algoritmo).getPosibilidadDeEmpate(partido, proveedor);
	}
	
	
	@Test
	public void suma1APosibilidadDeVictoriaLocal() {
		when(algoritmo.getPosibilidadDeVictoriaLocal(partido, proveedor)).thenReturn(0.3);
		
		assertEquals(admin.getCuotaDeVictoriaLocal(partido),1.3, 0.0);
	}
	
	
	@Test
	public void suma1APosibilidadDeVictoriaVisitante() {
		when(algoritmo.getPosibilidadDeVictoriaVisitante(partido, proveedor)).thenReturn(0.5);
		
		assertEquals(admin.getCuotaDeVictoriaVisitante(partido),1.5, 0.0);
	}
	
	
	@Test
	public void suma1APosibilidadDeEmpate() {
		when(algoritmo.getPosibilidadDeEmpate(partido, proveedor)).thenReturn(0.2);
		
		assertEquals(admin.getCuotaDeEmpate(partido),1.2, 0.0);
	}
}
