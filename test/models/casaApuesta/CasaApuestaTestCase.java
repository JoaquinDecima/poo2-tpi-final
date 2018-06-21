package models.casaApuesta;

import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;

import casaApuesta.CasaApuesta;
import competidor.Competidor;
import competidor.Equipo;
import deporte.Deporte;
import evento.Evento;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidad;
import proveedores.Proveedor;
import usuario.Usuario;

public class CasaApuestaTestCase {
	
	private CasaApuesta casaApuesta;
	private Partido partido;
	private Proveedor proveedorDataPartidos;
	private AlgoritmoProbabilidad algoritmoProbabilidadASetear;
	private Usuario usuario;
	private Competidor mockJugadorLocal;
	private Competidor mockJugadorVisitante;
	private Deporte mockDeporte; 
	private Date mockDate;
	
	@Before
	public void setUp(){
		
		mockDate = mock(Date.class);
		mockJugadorLocal = mock(Equipo.class);
		mockJugadorVisitante = mock(Equipo.class);
		mockDeporte = mock(Deporte.class);
		when(mockDeporte.permiteEmpate()).thenReturn(false);
		casaApuesta = new CasaApuesta(proveedorDataPartidos, algoritmoProbabilidadASetear); 
		partido = new Partido(mockJugadorLocal, mockJugadorVisitante, mockDeporte, mockDate, "Avellaneda");
		usuario = mock(Usuario.class);		
		
	}

	
	// cuando un partido finaliza, la casa de apuestas debe pagar las ganancias de los usuarios que apostaron en el evento
	public void pagarGanancias(Evento e) {
		e.getApuestasRealizadas().map(a-> a.usuario.calcularGananciaApuesta(a))
		
		
		
	}

}