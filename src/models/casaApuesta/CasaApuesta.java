package models.casaApuesta;


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
import java.util.List;
import java.util.stream.Collectors;

import models.apuesta.Apuesta;
import models.balance.BalanceManager;
import models.cuota.AdminCuota;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.Partido;
import models.probabilidad.AlgoritmoProbabilidad;
import models.proveedores.Proveedor;
import models.usuario.Usuario;

public class CasaApuesta {
	
	ArrayList<Evento> eventos = new ArrayList<Evento>();
	Proveedor proveedorDataPartidos;
	ArrayList<Deporte> deportesQueParticipan;
	AdminCuota administradorCuotasEventos;
	AlgoritmoProbabilidad algoritmoProbabilidadSeteado;
	BalanceManager balanceador;
	
	// Constructor
	public CasaApuesta(Proveedor proveedorDataPartidos, AlgoritmoProbabilidad algoritmoProbabilidadASetear ) {
		this.proveedorDataPartidos = proveedorDataPartidos; 
		this.algoritmoProbabilidadSeteado = algoritmoProbabilidadASetear;
		this.administradorCuotasEventos = new AdminCuota(this.proveedorDataPartidos, this.algoritmoProbabilidadSeteado);
		this.balanceador = new BalanceManager();
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
	
	// Realiza Todos los balances de la Casa de Apuesta
	public void balanceMensual() {
		ArrayList<Apuesta> apuestas = this.getApuestas();
		
		for (Usuario user : this.getUsuarios()) {
			this.balanceador.enviarBalance(user, apuestas);
		}
	}

	// Retorna la lista de Apuestas
	public ArrayList<Apuesta> getApuestas() {
		ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
		for (Evento event : this.eventos) {
			apuestas.addAll(event.getApuestasRealizadas());
		}
		return apuestas;
	}

	// Retorna una lista de usuarios
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for (Evento event : this.eventos) {
			usuarios.addAll(event.getUsuariosDeApuestas());
		}
		return usuarios;
	}
	
	public List<Evento> getEventosDisponibles(){
		return this.eventos.stream()
	    .filter(e -> e.estaDisponible()).collect(Collectors.toList());
	}
	
	
}






