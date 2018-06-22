package models.casaApuesta;

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
	
	private CasaApuesta casaApuesta;
	private Partido partido;
	private Proveedor proveedorDataPartidos;
	private AlgoritmoProbabilidad algoritmoProbabilidadASetear;
	private AdminCuota administradorCuotasEventos;
	private Usuario usuario;
	private Competidor mockJugadorLocal;
	private Competidor mockJugadorVisitante;
	private Deporte mockDeporte; 
	private Date mockDate;
	private Evento evento;
	
	@Before
	public void setUp(){
		
		mockDeporte = mock(Deporte.class);
		when(mockDeporte.permiteEmpate()).thenReturn(false);
		
		mockDate = mock(Date.class);
		mockJugadorLocal = mock(Equipo.class);
		mockJugadorVisitante = mock(Equipo.class);
		partido = new Partido(mockJugadorLocal, mockJugadorVisitante, mockDeporte, mockDate, "Avellaneda");
		
		algoritmoProbabilidadASetear = new AlgoritmoProbabilidadHistoricaReciente();
		casaApuesta = new CasaApuesta(proveedorDataPartidos, algoritmoProbabilidadASetear); 	
		usuario = new Usuario("diego");
	}

	
	
	
	
	@Test
	public void testCuandoUnPartidoFinalizaLaCasaDeApuestasPagaGananciasAUsuariosConBaseAalgoritmoProbabilidadHistoricaReciente() {
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

};