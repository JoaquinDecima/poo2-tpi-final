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
		fail("Not yet implemented");
	}
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeVictoriaVisitante() {
		fail("Not yet implemented");
	}
	
	@Test
	public void preguntaAAlgoritmoPosibilidadDeEmpate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void suma1APosibilidadDeVictoriaLocal() {
		when(algoritmo.getPosibilidadDeVictoriaLocal(partido, proveedor)).thenReturn(0.3);
		
		fail("Not yet implemented");
	}
	
	@Test
	public void suma1APosibilidadDeVictoriaVisitante() {
		when(algoritmo.getPosibilidadDeVictoriaVisitante(partido, proveedor)).thenReturn(0.5);
		
		fail("Not yet implemented");
	}
	
	@Test
	public void suma1APosibilidadDeEmpate() {
		when(algoritmo.getPosibilidadDeEmpate(partido, proveedor)).thenReturn(0.3);
		
		fail("Not yet implemented");
	}
}
