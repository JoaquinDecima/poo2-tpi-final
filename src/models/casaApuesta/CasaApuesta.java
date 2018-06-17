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



// Importa utilidades java
import java.util.ArrayList;

import cuota.AdminCuota;
import deporte.Deporte;
import evento.Evento;
import juego.Partido;
import probabilidad.AlgoritmoProbabilidad;
import proveedores.Proveedor;

public class CasaApuesta{
	
	ArrayList<Evento> eventos;
	Proveedor proveedorDataPartidos;
	ArrayList<Deporte> deportesQueParticipan;
	AdminCuota administradorCuotasEventos;
	AlgoritmoProbabilidad algoritmoProbabilidadSeteado;
	
	// Constructor
	public CasaApuesta(Proveedor proveedorDataPartidos, AlgoritmoProbabilidad algoritmoProbabilidadASetear ) {
		this.proveedorDataPartidos = proveedorDataPartidos; 
		this.algoritmoProbabilidadSeteado = algoritmoProbabilidadASetear;
		this.administradorCuotasEventos = new AdminCuota(this.proveedorDataPartidos, this.algoritmoProbabilidadSeteado);

	}
		
	// Crea un evento deportivo
	public Evento crearEventoDeportivo(Partido partido) {
					
		Evento nuevoEvento = new Evento(partido, this.administradorCuotasEventos);
		return nuevoEvento;
	}

	public AdminCuota adminCuota() {
		return this.administradorCuotasEventos;
	}
	
	
}






