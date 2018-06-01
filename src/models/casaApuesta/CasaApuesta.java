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
import models.deporte.*;
import models.evento.*;
import models.juego.*;
import models.proveedores.*;

public class CasaApuesta{
	
	ArrayList<Evento> eventos;
	Proveedor proveedorDataPartidos;
	ArrayList<Deporte> deportesQueParticipan;
	CalculadorCuotasResultadosPosibles calculadorCuotasEventos;
	AlgoritmoCalculoProbabilidad algoritmoProbabilidadSeteado;
	
	public CasaApuesta(Proveedor proveedorDataPartidos, CalculadorCuotasResultadosPosibles algoritmoProbabilidadASetear) {
		this.calculadorCuotasEventos = algoritmoProbabilidadASetear;
		this.proveedorDataPartidos = proveedorDataPartidos; 
	}
		
	// Crea un evento deportivo
	public Evento crearEventoDeportivo(Partida partido) {
		Map<String, Integer> resultadosYCuotasPosibles = this.calcularCuotasResultadosPosibles(partido);
		Evento nuevoEvento = new Evento(partido, resultadosYCuotasPosibles);
		return nuevoEvento;
	}
		
		
	public Map<String, Integer> calcularCuotasResultadosPosibles(Partido partido) {
		AlgoritmoCalculoProbabilidadResultados algoritmoCalculoProbabilidadResultadosElegido = this.algoritmoProbabilidadSeteado;
		HistorialPartido historialCompetidores = this.proveedorDataPartidos.getHistorialPartido(partido); 
		Map<String, Integer> resultadosYCuotasPosibles = this.calculadorCuotasEventos.calcularCuotasResultadosPosibles(partido, historialCompetidores, algoritmoCalculoProbabilidadResultadosElegido);
		return resultadosYCuotasPosibles;			
	}


		
}
