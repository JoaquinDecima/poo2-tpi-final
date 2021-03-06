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

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import models.apuesta.Apuesta;
import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.cuota.AdminCuota;
import models.juego.ISubscriptorPartido;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.juego.resultado.ResultadoConEmpate;
import models.juego.resultado.ResultadoSinEmpate;
import models.usuario.Usuario;

/*
 * Responsabilidades:
 * - Almacena apuestas usuarios sobre partido
 * - Calcula y retorna las opciones de apuestas posibles(OpcionApuesta)
 * - Se encarga de colaborar con Apuestas para que actualicen ganancias
 * - Paga ganancias a usuarios correspondientes que hayan hecho apuestas en el partido
 */

public class Evento implements ISubscriptorPartido {

		private Partido partido;
		private AdminCuota adminCuotasApuestasPosibles;
		private ArrayList<Apuesta> apuestasRealizadas;
		private ArrayList<OpcionApuesta> opcionesApuestasPosibles;
		private boolean estaDisponible = true;


		public Evento(Partido partidoDelEvento, AdminCuota cuotasResultadosPosibles) {

			this.adminCuotasApuestasPosibles = cuotasResultadosPosibles;
			this.partido = partidoDelEvento;
			this.apuestasRealizadas = new ArrayList<Apuesta>();
			this.opcionesApuestasPosibles = new ArrayList<OpcionApuesta>();
			this.estaDisponible = true;
			
			}


		/*
		 *  Metodos getters
		 */

		public Partido getPartidoDelEvento() {
			return (this.partido);
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



		/*
		 * Metodo invocado cuando la casa de apuestas crea el evento.
		 * Setea array list con opciones de posibles resultados y sus correspondientes cuotas
		 */

		public void calcularOpcionesResultadosPosibles() {
			// se almacenan las opciones de apuestas posibles en un array list como variable interna
			// solo almacena la opcion de que el resultado sea un empate, si el deporte admite empates
			this.opcionesApuestasPosibles.add(this.calcularOpcionVictoriaLocal());
			this.opcionesApuestasPosibles.add(this.calcularOpcionVictoriaVisitante());
			if (this.partido.esDeporteConEmpate()) {
					this.opcionesApuestasPosibles.add(this.calcularOpcionEmpate());
			}
		}


		/*
		 * metodos auxiliares para calculos de opciones de apuestas posibles
		 */

		/*
		 *  metodos getters resultados posibles
		 */

		public Resultado getResultadoVictoriaLocal() {
			return new ResultadoSinEmpate(this.partido.getLocal(), this.partido.getVisitante());
		}

		public Resultado getResultadoVictoriaVisitante() {
			return new ResultadoSinEmpate(this.partido.getVisitante(), this.partido.getLocal());
		}

		public ResultadoConEmpate getResultadoEmpate() {
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

		public OpcionApuesta calcularOpcionEmpate() {
			Resultado resultadoEmpate = this.getResultadoEmpate();
			Double cuotaEmpate = this.getCuotaPorEmpate();
			OpcionApuesta opcionEmpate = new OpcionApuesta(resultadoEmpate, cuotaEmpate);
			return opcionEmpate;
		}

		public OpcionApuesta calcularOpcionVictoriaVisitante() {
			Resultado resultadoVictoriaVisitante = this.getResultadoVictoriaVisitante();
			Double cuotaVictoriaVisitante = this.getCuotaPorVictoriaVisitante();
			OpcionApuesta opcionVictoriaVisitante = new OpcionApuesta(resultadoVictoriaVisitante, cuotaVictoriaVisitante);
			return opcionVictoriaVisitante;
		}

		public OpcionApuesta calcularOpcionVictoriaLocal() {
			Resultado resultadoVictoriaLocal = this.getResultadoVictoriaLocal();
			Double cuotaVictoriaLocal = this.getCuotaPorVictoriaLocal();
			OpcionApuesta opcionVictoriaLocal = new OpcionApuesta(resultadoVictoriaLocal, cuotaVictoriaLocal);
			return opcionVictoriaLocal;
		}

		/*
		 * implementa interfaz de subscriptor a partidos
		 *
		 */

		@Override
		// cuando un partido finaliza el Evento paga si corresponde las ganancias a usuarios que hicieron apuestas
		public void updateFinalPartido() {
			this.setGananciasApuestas();
			this.pagarGananciasApuestas();
			this.getUsuariosDeApuestas().forEach(usuario->usuario.updateFinalPartido());
			this.quitarDisponibilidad();
		}
		
		public void quitarDisponibilidad() {
			this.estaDisponible = false;
			
		}


		@Override
		public void updateInicioPartido() {
			this.getUsuariosDeApuestas().forEach(usuario->usuario.updateInicioPartido());
		}


		private void setGananciasApuestas() {
			// setear las ganancias por cada apuesta realizada en el evento
			for(Apuesta apuesta : this.getApuestasRealizadas()) {
					apuesta.calcularGanancias();
			}
		}

		private void pagarGananciasApuestas() {

			for(Apuesta apuesta : this.getApuestasRealizadas()) {
				apuesta.getUsuario().incrementarMontoWallet(apuesta.gananciaBruta());	
			}
		}

		/*
		 * Metodos invocados por EstadoPartido
		 */

		public void registrarNuevaApuesta(Apuesta nuevaApuesta) {
			this.apuestasRealizadas.add(nuevaApuesta);
		}


		public void cobrarPenalidadApuestaCanceladaConPartidoEnCurso(ApuestaSegura apuestaACancelar) {
			// si el partido esta en curso y el usuario la cancela, se le descuenta el 15% de lo que apostó.
		apuestaACancelar.getUsuario().decrementarMontoWallet((apuestaACancelar.montoApostado()*30) / 100);

		}

		public void cobrarPenalidadApuestaCanceladaConPartidoProximo(ApuestaSegura apuestaACancelar) {
			// si el partido esta en curso y el usuario la cancela, se le descuenta el 15% de lo que apostó.
		apuestaACancelar.getUsuario().decrementarMontoWallet(200.00);

		}

		// Retorna la fecha del partido
		public Date getFecha() {
			return (this.partido.getFechaDate());
		}


		public ArrayList<Usuario> getUsuariosDeApuestas() {
		
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

			for (Apuesta apuesta : this.apuestasRealizadas) {
				
				if(!usuarios.contains(apuesta.getUsuario())) {
			
					usuarios.add(apuesta.getUsuario());
				}		
			}
			return usuarios;
		}


		public boolean estaDisponible() {
			return this.estaDisponible;
		}


		public void sumApuesta(Apuesta nuevaApuesta) {
			this.apuestasRealizadas.add(nuevaApuesta);
		}








}
