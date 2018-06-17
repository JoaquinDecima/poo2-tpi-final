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

package models.casaApuesta;

// Importa utilidades java
import java.util.ArrayList;

//Importa del Modelo
import models.cuota.*;
import models.deporte.*;
import models.evento.*;
import models.juego.*;
import models.probabilidad.*;
import models.proveedores.*;

public class CasaApuesta{
	
	ArrayList<Evento> eventos;
	Proveedor proveedorDataPartidos;
	ArrayList<Deporte> deportesQueParticipan;
	AdminCuota administradorCuotasEventos;
	AlgoritmoProbabilidad algoritmoProbabilidadSeteado;
	
	// Constructor
	public CasaApuesta(Proveedor proveedorDataPartidos, AdminCuota administradorCuotasEventosASetear, AlgoritmoProbabilidad algoritmoProbabilidadASetear ) {
		this.administradorCuotasEventos = administradorCuotasEventosASetear;
		this.proveedorDataPartidos = proveedorDataPartidos; 
		this.algoritmoProbabilidadSeteado = algoritmoProbabilidadASetear;
	}
		
	// Crea un evento deportivo
	public Evento crearEventoDeportivo(Partido partido) {
		
		AdminCuota adminCuotas = new AdminCuota(this.proveedorDataPartidos, this.algoritmoProbabilidadSeteado);
			
		Evento nuevoEvento = new Evento(partido, adminCuotas);
		return nuevoEvento;
	}		
}






