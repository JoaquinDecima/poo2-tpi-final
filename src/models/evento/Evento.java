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
import java.util.stream.Collectors;

import apuesta.Apuesta;
import apuesta.ApuestaSegura;
import apuesta.OpcionApuesta;
import cuota.AdminCuota;
import juego.Partido;
import juego.Resultado;
import usuario.Usuario;


public class Evento {
	
		Partido partido;
		AdminCuota adminCuotasApuestasPosibles;
		ArrayList<Apuesta> apuestasRealizadas;
		
		public Evento(Partido partido, AdminCuota cuotasResultadosPosibles) {
			
			this.adminCuotasApuestasPosibles = cuotasResultadosPosibles;
			this.setPartidoDelEvento(partido);	
			this.apuestasRealizadas = new ArrayList<Apuesta>();
			// pensar en la posibilidad de que evento tenga un estado que dependa del estado del partido
			}
		
		// metodos getters

		public Partido getPartidoDelEvento() {
			return this.partido;
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
		
		// retorna una lista de apuestas realizadas por usuario en evento
		public ArrayList<Apuesta> getApuestasUsuario(Usuario usuario) {	
			return (apuestasRealizadas.stream().filter( a -> a.getUsuario() == usuario)).collect(Collectors.toCollection(ArrayList::new));
		}
			
		public Resultado getResultadoPartido() {
			return this.partido.getResultado();		
		}
	
		// retorna la opcion de apuesta por victoria local que usuario puede elegir p/ hacer apuesta
		public OpcionApuesta getOpcionAPuestaVictoriaLocal() {
			//TODO
			return  null;
			
				}
		// metodos setters

		private void setPartidoDelEvento(Partido partidoDelEvento) {
			this.partido = partidoDelEvento;
		}
		
		// metodos void

		public ApuestaSegura addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta,
				double monto) throws Exception{
			// checueo que el partido no haya finalizado
			if(!this.partido.finalizado()) {
				// si no finalizo el partido, entonces se crea la apuesta solicitada por el usuario
				ApuestaSegura nuevaApuesta = new ApuestaSegura(usuario, this, opcionApuesta, monto);
				this.apuestasRealizadas.add(nuevaApuesta);
				// retorno nueva apuesta
				return nuevaApuesta;
			} 
				// si el partido ha finalizado, entonces se lanza excepcion
				else throw new Exception();
		}

		public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception {
			
			// se chequea que el partido no haya finalizado
			if(!this.partido.finalizado()) {
				// se cobra penalidad por cancelacion
				this.cobrarPenalidadApuestaCancelada(apuestaACancelar);
				// cambia estado de la apuesta. Ahora ya no esta activa.
				apuestaACancelar.updateEstado();			
			} else {
				// si el partido ha finalizado no se puede cancelar una apuesta segura
				throw new Exception();
			}	
		}
		
		private void cobrarPenalidadApuestaCancelada(ApuestaSegura apuestaACancelar) {
			Usuario usuarioPenalizado = apuestaACancelar.getUsuario();
			// Si el partido aun no ha comenzado, cobrar penalidad fija de 200 pesos.
			if(apuestaACancelar.getPartido().esProximo()) {
				usuarioPenalizado.decrementarMontoWallet(200.00);
			} else {
				Double montoACobrar = ((apuestaACancelar.montoApostado()) * 30.0) / 100.0;
				usuarioPenalizado.decrementarMontoWallet(montoACobrar);
				}
		}
		
		// Reactiva una apuesta ya cancelada. Cambia el estado de la apuesta: se activa.
		// Invariante: se debe tratar de una apuesta cancelada.
		public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception {
			// Solo se puede reactivar una apuesta cuando el partido aun no ha comenzado.
			if(apuestaAReactivar.getPartido().esProximo()) {
				apuestaAReactivar.updateEstado();
			} else {	
				// Si el partido esta en curso o ha finalizado, se lanza una excepcion.
				throw new Exception();
			}			
		}

		public ArrayList<Apuesta> getApuestasRealizadas() {
			return this.apuestasRealizadas;
			
		}
}
