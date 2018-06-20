package models.probabilidad;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import competidor.Competidor;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidadHistoricaDirecta;
import proveedores.Proveedor;

public class AlgoritmoProbabilidadHistoricaDirectaTestCase {
	Partido partida = mock(Partido.class);
	Proveedor proveedor = mock(Proveedor.class);
	Competidor competidor = mock(Competidor.class);
	AlgoritmoProbabilidadHistoricaDirecta algoritmo = new AlgoritmoProbabilidadHistoricaDirecta();
	
	@Test
	public void PreguntaPorLocal() {
		when(partida.getLocal()).thenReturn(competidor);
		when(partida.getVisitante()).thenReturn(competidor);
		when(proveedor.cantDePartidosEntre(competidor, competidor)).thenReturn(10);
		when(proveedor.victoriasDeEnPartidos(competidor, competidor, 10)).thenReturn(4);
		
		assertEquals(algoritmo.getPosibilidadDeVictoriaLocal(partida, proveedor),0.4, 0.5);
	}
	
	@Test
	public void PreguntaPorVisitante() {
		when(partida.getLocal()).thenReturn(competidor);
		when(partida.getVisitante()).thenReturn(competidor);
		when(proveedor.cantDePartidosEntre(competidor, competidor)).thenReturn(10);
		when(proveedor.victoriasDeEnPartidos(competidor, competidor, 10)).thenReturn(5);
		
		assertEquals(algoritmo.getPosibilidadDeVictoriaVisitante(partida, proveedor),0.5, 0.5);
	}
	
	@Test
	public void PreguntaPorEmpate() {
		when(partida.getLocal()).thenReturn(competidor);
		when(partida.getVisitante()).thenReturn(competidor);
		when(proveedor.cantDePartidosEntre(competidor, competidor)).thenReturn(10);
		when(proveedor.empatesDeEnPartidos(competidor, competidor, 10)).thenReturn(1);
		
		assertEquals(algoritmo.getPosibilidadDeEmpate(partida, proveedor),0.1, 0.1);
	}
}
