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
import juego.ISubscriptorPartido;
import juego.Partido;
import juego.Resultado;
import juego.ResultadoConEmpate;
import juego.ResultadoSinEmpate;
import usuario.Usuario;


public class Evento implements ISubscriptorPartido {
	
		Partido partido;
		AdminCuota adminCuotasApuestasPosibles;
		ArrayList<Apuesta> apuestasRealizadas;
		ArrayList<OpcionApuesta> opcionesApuestasPosibles;
		EstadoEvento estado;
		
		
		public Evento(Partido partidoDelEvento, AdminCuota cuotasResultadosPosibles) {
			
			this.adminCuotasApuestasPosibles = cuotasResultadosPosibles;
			this.partido = partidoDelEvento;	
			this.apuestasRealizadas = new ArrayList<Apuesta>();
			this.estado = new PartidoProximo(this);
			}
	
		
		// metodos getters

		public Partido getPartidoDelEvento() {
			return this.partido;
		}
		
		public ArrayList<OpcionApuesta> getOpcionesResultadosPosibles() {
			return this.opcionesApuestasPosibles;
		}
		
		// retorna una lista de apuestas realizadas por usuario en evento
		public ArrayList<Apuesta> getApuestasUsuario(Usuario usuario) {	
			return (apuestasRealizadas.stream().filter( a -> a.getUsuario() == usuario)).collect(Collectors.toCollection(ArrayList::new));
		}
			
		public Resultado getResultadoPartido() {
			return this.partido.getResultado();		
		}
		
		public ArrayList<Apuesta> getApuestasRealizadas() {
			return this.apuestasRealizadas;
			
		}
		

		
		
		// metodos invocados por usuario

		public void addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception {
			this.estado.addApuestaSegura(usuario, opcionApuesta, monto);		
		}

		public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception {
			this.estado.cancelarApuestaSegura(apuestaACancelar);
		}
		
		void cobrarPenalidadApuestaCancelada(ApuestaSegura apuestaACancelar) {
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
			this.estado.reactivarApuestaSegura(apuestaAReactivar);
		}
	
		
	
		
		
		// setea array list con opciones de posibles resultados y sus correspondientes cuotas
		// es invocado cuando la casa de apuestas crea el evento
		
		public void calcularOpcionesResultadosPosibles() {
			// se almacenan las opciones de apuestas posibles en un array list como variable interna 
			// solo almacena la opcion de que el resultado sea un empate, si el deporte admite empates
			this.opcionesApuestasPosibles = new ArrayList<OpcionApuesta>();
			this.opcionesApuestasPosibles.add(this.calcularOpcionVictoriaLocal());
			this.opcionesApuestasPosibles.add(this.calcularOpcionVictoriaVisitante());
			if (this.partido.getDeporte().permiteEmpate()) {
					this.opcionesApuestasPosibles.add(this.calcularOpcionEmpate());
			}
		}
		
		
		/* 
		 * metodos auxiliares para calculos de opciones de apuestas posibles
		 */
		
		/*
		 *  metodos getters resultados posibles
		 */
				
		private Resultado getResultadoVictoriaLocal() {
			return new ResultadoSinEmpate(this.partido.getLocal(), this.partido.getVisitante());
		}
		
		private Resultado getResultadoVictoriaVisitante() {
			return new ResultadoSinEmpate(this.partido.getVisitante(), this.partido.getLocal());
		}

		private ResultadoConEmpate getResultadoEmpate() {
			return new ResultadoConEmpate(this.partido.getLocal(), this.partido.getVisitante(), true);
		}
		
		
		/*
		 *  metodos getters cuotas por resultados posibles
		 */
		
		// Retorna la cuota establecida en caso de victoria de competidor local
		private double getCuotaPorVictoriaLocal() {
			return(this.adminCuotasApuestasPosibles.getCuotaPorVictoriaLocal(this.partido));
		}
		
		// Retorna la cuota establecida en caso de victoria visitante
		private double getCuotaPorVictoriaVisitante() {
			return(this.adminCuotasApuestasPosibles.getCuotaPorVictoriaVisitante(this.partido));
		}
		
		// Retorna la cuota establecida en caso de empate
		private double getCuotaPorEmpate() {
			return(this.adminCuotasApuestasPosibles.getCuotaPorEmpate(this.partido));
		}
		
		
		/*
		 *  metodos getters que devuelven opciones de apuestas calculadas
		 */
			
		private OpcionApuesta calcularOpcionEmpate() {
			Resultado resultadoEmpate = this.getResultadoEmpate();
			Double cuotaEmpate = this.getCuotaPorEmpate();
			OpcionApuesta opcionEmpate = new OpcionApuesta(resultadoEmpate, cuotaEmpate);
			return opcionEmpate;
		}

		private OpcionApuesta calcularOpcionVictoriaVisitante() {
			Resultado resultadoVictoriaVisitante = this.getResultadoVictoriaVisitante();
			Double cuotaVictoriaVisitante = this.getCuotaPorVictoriaVisitante();
			OpcionApuesta opcionVictoriaVisitante = new OpcionApuesta(resultadoVictoriaVisitante, cuotaVictoriaVisitante);
			return opcionVictoriaVisitante;
		}

		private OpcionApuesta calcularOpcionVictoriaLocal() {
			Resultado resultadoVictoriaLocal = this.getResultadoVictoriaLocal();
			Double cuotaVictoriaLocal = this.getCuotaPorVictoriaLocal();
			OpcionApuesta opcionVictoriaLocal = new OpcionApuesta(resultadoVictoriaLocal, cuotaVictoriaLocal);
			return opcionVictoriaLocal;		
		}


		// implementa interfaz de subscriptor a partidos

		@Override
		// cuando un partido finaliza debe calcular ganancias de usuarios del evento creado
		public void updateFinalPartido() {
			this.estado = new Finalizado(this);															
			this.estado.accionar();
			
		}
		
	
		// metodos que se ejecutan al finalizar un partido

		void setGananciasApuestas() {
			// setear las ganancias por cada apuesta realizada en el evento
			for(Apuesta apuesta : this.getApuestasRealizadas()) {
				
				Resultado resultadoFinal = apuesta.getPartido().getResultado();
				Resultado resultadoApostado = apuesta.opcionApostada().resultado();
				
				boolean usuarioGanaApuesta = (resultadoFinal == resultadoApostado); 	
						
				if (usuarioGanaApuesta) {				
					Double gananciaBruta = (apuesta.montoApostado()) * (apuesta.opcionApostada().cuota());
					Double gananciaNeta = gananciaBruta - (apuesta.montoApostado());
					
					// se setean las ganancias en la apuesta
					this.setearGananciasApuesta(apuesta, gananciaBruta, gananciaNeta);
					// se incrementa usuario wallet con la ganancia neta
					this.pagarGananciasUsuario(apuesta);
					
				}	else {
					// si el usuario no acertó el resultado, entonces obtiene ganancias 0 pesos.
						this.setearGananciasApuesta(apuesta, 0.00, 0.00);
				}
			}	
		}

		private void pagarGananciasUsuario(Apuesta apuesta) {
			Usuario usuario = apuesta.getUsuario();
			usuario.incrementarMontoWallet(apuesta.ganaciaNeta());
			if(apuesta instanceof ApuestaSegura) {
				this.cobrarDescPorApuestaSegura(apuesta);						
			}
			
		}

		private void cobrarDescPorApuestaSegura(Apuesta apuesta) {	
			Usuario usuario = apuesta.getUsuario();
			usuario.decrementarMontoWallet((apuesta.ganaciaNeta()*15) / 100);
		}

		private void setearGananciasApuesta(Apuesta apuesta, Double gananciaBruta, Double gananciaNeta) {
			apuesta.setGananciaBruta(gananciaBruta);
			apuesta.setGananciaNeta(gananciaNeta);		
		}
		
		
}
