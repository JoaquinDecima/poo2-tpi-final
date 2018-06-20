package models.casaApuesta;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import apuesta.OpcionApuesta;
import casaApuesta.CasaApuesta;
import evento.Evento;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidad;
import proveedores.Proveedor;
import usuario.Usuario;

public class CasaApuestaTestCase {
	
	private CasaApuesta casaApuesta;
	private Partido mockPartido;
	private Proveedor proveedorDataPartidos;
	private AlgoritmoProbabilidad algoritmoProbabilidadASetear;
	private Usuario usuario;
	
	@Before
	public void setUp(){
					
		casaApuesta = new CasaApuesta(proveedorDataPartidos, algoritmoProbabilidadASetear); 
		mockPartido = mock(Partido.class);
		usuario = mock(Usuario.class);		
		
	}

	

	public void pagarGanancias(Evento e) {
		
		//el partido ya finalizo, la casa de apuestas recibio notificacion al respecto
		
	}

}