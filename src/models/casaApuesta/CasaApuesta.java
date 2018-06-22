package casaApuesta;


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

public class CasaApuesta {
	
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
	
	public AdminCuota getAdminCuota() {
		return this.administradorCuotasEventos;
	}
		
	// Crea un evento deportivo
	public Evento crearEventoDeportivo(Partido partido) {

		// se instancia nuevo Evento y se pasa objeto AdminCuota para que pueda delegar el calculo de las cuotas y opciones de resultados posibles
		Evento nuevoEvento = new Evento(partido, this.getAdminCuota());
		nuevoEvento.calcularOpcionesResultadosPosibles();
		// se agrega el evento al registro de eventos de la casa de apuestas
		this.eventos.add(nuevoEvento);
		// sistema de notificaciones: la casa de apuestas se subscribe a los eventos de partido;
		partido.addSubscriptor(nuevoEvento);
		// se retorna el evento creado
		return nuevoEvento;
	}
	
	// Setea Nuevo Algoritmo
	public void setAlgoritmoProbabilidad(AlgoritmoProbabilidad algoritmoNuevo) {
		this.algoritmoProbabilidadSeteado = algoritmoNuevo;
	}
	
	// Retorna Algoritmo
	public AlgoritmoProbabilidad getAlgoritmoProbabilidad() {
		return(this.algoritmoProbabilidadSeteado);
	}
}






