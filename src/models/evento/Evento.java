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
import apuesta.OpcionApuesta;
import cuota.AdminCuota;
import juego.ISubscriptorPartido;
import juego.Partido;
import juego.Resultado;
import usuario.Usuario;


public class Evento {
	
		Partido partido;
		AdminCuota adminCuotasApuestasPosibles;
		ArrayList<Apuesta> apuestasRealizadas;
		boolean estaActivo;
		
		public Evento(Partido partido, AdminCuota cuotasResultadosPosibles) {
			
			this.adminCuotasApuestasPosibles = cuotasResultadosPosibles;
			this.setPartidoDelEvento(partido);		
			}

		public Partido getPartidoDelEvento() {
			return partido;
		}

		private void setPartidoDelEvento(Partido partidoDelEvento) {
			this.partido = partidoDelEvento;
		}
		
		// Retorna la cuota establecida en caso de victoria de competidor local
		public double getCuotaPorVictoriaLocal() {
			return(this.adminCuotasApuestasPosibles.getCuotaPorVictoriaLocal(this.partido));
		}
		
		// Retorna la cuota establecida en caso de derrota de competidor local
		public double getCuotaPorVictoriaVisitante() {
			return(this.adminCuotasApuestasPosibles.getCuotaPorVictoriaVisitante(this.partido));
		}
		
		// la cuota establecida en caso de empate
		public double getCuotaPorEmpate() {
			return(this.adminCuotasApuestasPosibles.getCuotaPorEmpate(this.partido));
		}

		public ArrayList<Apuesta> getApuestasUsuario(Usuario usuario, Evento evento) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Resultado getResultadoPartido() {
			return this.partido.getResultado();
			
		}
		
		public void addApuestaSegura(Apuesta apuestaUsuario) {
			this.apuestasRealizadas.add(apuestaUsuario);
			
		}
		
		
		

}
