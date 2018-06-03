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
import java.util.Date;
import java.util.Map;

// Importa del Modelo
import models.cuota.*;
import models.juego.*;

public class Evento {
	
		Partido partidoDelEvento;
		AdminCuota posibilidadesDeApuestas;
		
		public Evento(Partido partido, AdminCuota cuotasResultadosPosibles) {
			
			this.posibilidadesDeApuestas = cuotasResultadosPosibles;
			this.setPartidoDelEvento(partido);
			
			}

		public Partido getPartidoDelEvento() {
			return partidoDelEvento;
		}

		private void setPartidoDelEvento(Partido partidoDelEvento) {
			this.partidoDelEvento = partidoDelEvento;
		}
		
		// Retorna la posibilidad de Victoria de un equipo
		public double getCuotaDeVictoriaLocal(Partido pPartido) {
			return(this.posibilidadesDeApuestas.getCuotaDeVictoriaLocal(pPartido));
		}
		
		// Retorna la posibilidad de Victoria de un equipo
		public double getCuotaDeVictoriaVisitante(Partido pPartido) {
			return(this.posibilidadesDeApuestas.getCuotaDeVictoriaVisitante(pPartido));
		}
		
		// Retorna la posibilidad de empate de un equipo
		public double getCuotaDeEmpate(Partido pPartido) {
			return(getCuotaDeEmpate(pPartido));
		}
		

}
