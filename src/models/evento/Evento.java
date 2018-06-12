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

package models.evento;

// Importa utilidades Java


// Importa del Modelo
import models.cuota.*;
import models.juego.*;

public class Evento {
	
		Partido partido;
		AdminCuota apuestasPosibles;
		
		public Evento(Partido partido, AdminCuota cuotasResultadosPosibles) {
			
			this.apuestasPosibles = cuotasResultadosPosibles;
			this.setPartidoDelEvento(partido);
			
			}

		public Partido getPartidoDelEvento() {
			return partido;
		}

		private void setPartidoDelEvento(Partido partidoDelEvento) {
			this.partido = partidoDelEvento;
		}
		
		// Retorna la posibilidad de Victoria de un equipo
		public double getCuotaPorVictoriaLocal() {
			return(this.apuestasPosibles.getCuotaPorVictoriaLocal(this.partido));
		}
		
		// Retorna la posibilidad de Victoria de un equipo
		public double getCuotaPorVictoriaVisitante() {
			return(this.apuestasPosibles.getCuotaPorVictoriaVisitante(this.partido));
		}
		
		// Retorna la posibilidad de empate de un equipo
		public double getCuotaPorEmpate(Partido pPartido) {
			return(this.apuestasPosibles.getCuotaPorEmpate(this.partido));
		}
		

}
