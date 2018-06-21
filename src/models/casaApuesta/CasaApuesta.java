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

import apuesta.Apuesta;
import apuesta.ApuestaSegura;
import cuota.AdminCuota;
import deporte.Deporte;
import evento.Evento;
import juego.ISubscriptorPartido;
import juego.Partido;
import juego.Resultado;
import probabilidad.AlgoritmoProbabilidad;
import proveedores.Proveedor;
import proveedores.ProveedorDataPartido;
import usuario.Usuario;

public class CasaApuesta implements ISubscriptorPartido{
	
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
		partido.addSubscriptor(this);
		Evento nuevoEvento = new Evento(partido, this.getAdminCuota());
		this.eventos.add(nuevoEvento);
		return nuevoEvento;
	}


	
	public void setAlgoritmoProbabilidad(AlgoritmoProbabilidad algoritmoNuevo) {
		this.algoritmoProbabilidadSeteado = algoritmoNuevo;
	}
	
	// implementa interfaz de subscriptor a partidos

	@Override
	// cuando un partido finaliza debe calcular ganancias de usuarios del evento creado
	public void updateFinalPartido(Partido p) {
		Evento eventoPartido = (this.eventos.stream()
											.filter(e -> e.getPartidoDelEvento() == p)
													.findFirst()).get();				
		this.calcularGananciasEvento(eventoPartido);
	}

	private void calcularGananciasEvento(Evento eventoPartido) {
		for(Apuesta apuesta : eventoPartido.getApuestasRealizadas()) {
			this.setGananciasApuesta(apuesta);
			
		}
		

	}

	private void setGananciasApuesta(Apuesta apuesta) {
		Resultado resultadoFinal = apuesta.getPartido().getResultado();
		boolean usuarioGanaApuesta = resultadoFinal == apuesta.opcionApostada().resultado(); 
		Usuario usuario = apuesta.getUsuario();
		
		if (usuarioGanaApuesta) {
			if(apuesta instanceof ApuestaSegura) {
				usuario.incrementarMontoWallet(monto);
				this.cobrarDescuento()
				
				
			}
					
					
		}
		
	}

	
}






