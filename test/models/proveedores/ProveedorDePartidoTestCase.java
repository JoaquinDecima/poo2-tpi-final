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
import java.util.Date;

// Importa desde org
import org.junit.Test;
import org.mockito.Mockito;

import models.competidor.Competidor;
import models.deporte.Deporte;
import models.juego.Partido;
// Importa del Modelo
import models.proveedores.ProveedorDePartido;

public class ProveedorDePartidoTestCase {
	private ProveedorDePartido partidos = new ProveedorDePartido();
	private ArrayList<Partido> listapartidos = new ArrayList<Partido>();
	
	private Deporte deporte1 = mock(Deporte.class);
	
	private Competidor local = mock(Competidor.class);
	private Competidor visitante = mock(Competidor.class);
	
	private Date fecha1 = new Date();
	
	private Partido partido1 = mock(Partido.class);
	private Partido partido2 = mock(Partido.class);
	private Partido partido3 = mock(Partido.class);
	private Partido partidoSpy = Mockito.spy(new Partido(local, visitante, deporte1, fecha1, "Quilmes"));
	
	@Test
	public void testAddPartido() {
		assertEquals(partidos.getPatridosAll().size(),0);
		partidos.addPartido(partido1);
		assertEquals(partidos.getPatridosAll().size(),1);
	}

	@Test
	public void testGetAllPartidos() {
		partidos.addPartido(partido1);
		partidos.addPartido(partido2);
		partidos.addPartido(partido3);
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		
		assertEquals(partidos.getPatridosAll(), listapartidos);
	}
	
	@Test
	public void testPartidosDelDeporte() {
		partidos.addPartido(partido1);
		partidos.addPartido(partido2);
		partidos.addPartido(partido3);
		listapartidos.add(partido1);
		listapartidos.add(partido2);
		
		when(partido1.esDeporte(deporte1)).thenReturn(true);
		when(partido2.esDeporte(deporte1)).thenReturn(true);
		when(partido3.esDeporte(deporte1)).thenReturn(false);
		
		assertEquals(partidos.getPartidosDeDeporte(deporte1), listapartidos);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPartidosDeFecha(){
		partidos.addPartido(partido1);
		partidos.addPartido(partido2);
		partidos.addPartido(partido3);
		listapartidos.add(partido1);
		listapartidos.add(partido3);
		//TODO:hAY QUE USAR MODULO JODA TIME PARA LAS FECHAS
		when(partido1.getFecha()).thenReturn(fecha1);
		when(partido2.getFecha()).thenReturn(fecha1 - 1);
		when(partido3.getFecha()).thenReturn(fecha1);
		
		assertEquals(partidos.getPartidosDeFecha(fecha1), listapartidos);
	}
	
	@Test
	public void testPartidosQueSeJueganEn() {
		partidos.addPartido(partido1);
		partidos.addPartido(partido2);
		partidos.addPartido(partido3);
		listapartidos.add(partido2);
		listapartidos.add(partido3);
		
		when(partido1.getLugarDeJuego()).thenReturn("La Plata");
		when(partido2.getLugarDeJuego()).thenReturn("Quilmes");
		when(partido3.getLugarDeJuego()).thenReturn("Quilmes");
		
		assertEquals(partidos.getPartidosQueSeJueguenEn("Quilmes"), listapartidos);
	}
	
	@Test
	public void testCambioDeEstado() {
		partidos.iniciarPartido(partidoSpy);
		assertTrue(partidoSpy.enCurso());
		
		partidos.finalizarPartido(partidoSpy);
		assertTrue(partidoSpy.finalizado());
	}
}
