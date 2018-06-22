package models.casaApuesta;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import casaApuesta.CasaApuesta;
import competidor.Competidor;
import competidor.Equipo;
import cuota.AdminCuota;
import deporte.Deporte;
import evento.Evento;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidad;
import probabilidad.AlgoritmoProbabilidadHistoricaReciente;
import proveedores.Proveedor;
import usuario.Usuario;

public class CasaApuestaTestCase {
	private Proveedor proveedor = mock(Proveedor.class);
	private AlgoritmoProbabilidad algoritmo = mock(AlgoritmoProbabilidad.class);
	private AlgoritmoProbabilidad algoritmo2 = mock(AlgoritmoProbabilidad.class);
	private CasaApuesta casa = new CasaApuesta(proveedor, algoritmo);
	
	private AdminCuota admin = casa.getAdminCuota();

	
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
};