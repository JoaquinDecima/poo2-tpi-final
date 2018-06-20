package models.probabilidad;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import competidor.Competidor;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidadHistoricaReciente;
import proveedores.Proveedor;

public class AlgoritmoProbabilidadHistoricaRecienteTestCase {
	Partido partida = mock(Partido.class);
	Proveedor proveedor = mock(Proveedor.class);
	Competidor competidor = mock(Competidor.class);
	AlgoritmoProbabilidadHistoricaReciente algoritmo = new AlgoritmoProbabilidadHistoricaReciente();
	
	@Test
	public void PreguntaPorLocal() {
		when(partida.getLocal()).thenReturn(competidor);
		when(partida.getVisitante()).thenReturn(competidor);
		when(proveedor.victoriasDeEnPartidos(competidor, 10)).thenReturn(4);
		
		assertEquals(algoritmo.getPosibilidadDeVictoriaLocal(partida, proveedor),0.4, 0.5);
	}
	
	@Test
	public void PreguntaPorVisitante() {
		when(partida.getLocal()).thenReturn(competidor);
		when(partida.getVisitante()).thenReturn(competidor);
		when(proveedor.victoriasDeEnPartidos(competidor, 10)).thenReturn(5);
		
		assertEquals(algoritmo.getPosibilidadDeVictoriaVisitante(partida, proveedor),0.5, 0.5);
	}
	
	@Test
	public void PreguntaPorEmpate() {
		when(partida.getLocal()).thenReturn(competidor);
		when(partida.getVisitante()).thenReturn(competidor);
		when(proveedor.empatesDeEnPartidos(competidor,  10)).thenReturn(1);
		
		assertEquals(algoritmo.getPosibilidadDeEmpate(partida, proveedor),0.1, 0.1);
	}
}
