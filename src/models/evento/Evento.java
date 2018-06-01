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
import models.juego.*;

public class Evento {
	
		Partida partidoDelEvento;
		Map<String, Integer> listaPosibilidadesDeApuestas;
		Date fechaEvento;
		String lugarEvento;
		
		public Evento(Partida partido, Map<String, Integer> listaCuotasResultadosPosibles) {
			
			this.listaPosibilidadesDeApuestas = listaCuotasResultadosPosibles;
			this.setPartidoDelEvento(partido);
			
			}

		public Partida getPartidoDelEvento() {
			return partidoDelEvento;
		}

		private void setPartidoDelEvento(Partida partidoDelEvento) {
			this.partidoDelEvento = partidoDelEvento;
		}
		
		public Map<String, Integer> getPosibilidadesDeApuestas() {
			return listaPosibilidadesDeApuestas;
		}
		

}
