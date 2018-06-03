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
import java.util.Map;

//Importa del Modelo
import models.competidor.*;
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
	AdminCuota calculadorCuotasEventos;
	AlgoritmoProbabilidad algoritmoProbabilidadSeteado;
	
	public CasaApuesta(Proveedor proveedorDataPartidos, AdminCuota algoritmoProbabilidadASetear) {
		this.calculadorCuotasEventos = algoritmoProbabilidadASetear;
		this.proveedorDataPartidos = proveedorDataPartidos; 
	}
		
	// Crea un evento deportivo
	public Evento crearEventoDeportivo(Partido partido) {
		AdminCuota resultadosYCuotasPosibles = new AdminCuota(this.proveedorDataPartidos, this.algoritmoProbabilidadSeteado);
		Evento nuevoEvento = new Evento(partido, resultadosYCuotasPosibles);
		return nuevoEvento;
	}		
}
