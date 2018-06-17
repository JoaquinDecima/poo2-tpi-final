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

package evento;

import java.util.ArrayList;

import apuesta.Apuesta;
import cuota.AdminCuota;
import juego.Partido;
import usuario.Usuario;


public class Evento {
	
		Partido partido;
		AdminCuota apuestasPosibles;
		ArrayList<Usuario> apuestasHechas;
		
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

		public ArrayList<Apuesta> getApuestasUsuario(Usuario usuario, Evento evento) {
			// TODO Auto-generated method stub
			return null;
		}
		

}
