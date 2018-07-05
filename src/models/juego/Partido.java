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

package models.juego;

import java.util.ArrayList;
// Importa utilidades Java
import java.util.Date;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.competidor.Competidor;
import models.deporte.Deporte;
import models.evento.Evento;
import models.juego.estado.*;
import models.juego.resultado.Resultado;
import models.usuario.Usuario;

public class Partido{
  private Competidor local;
  private Competidor visitante;
  private Deporte deporte;
  private Date fecha;
  private String lugar;
  private EstadoPartido estado;
  private Resultado resultado;
  private ArrayList<ISubscriptorPartido> subscriptores = new ArrayList<ISubscriptorPartido>();


  public Partido(Competidor cLocal, Competidor cVisitante, Deporte dDeporte, Date dFecha, String sLugar) {
    this.local = cLocal;
    this.visitante = cVisitante;
    this.deporte = dDeporte;
    this.fecha = dFecha;
    this.lugar = sLugar;
    this.estado = new Proximo();
  }


  /*
   * El estado del partido se implementa a través de patron de diseño State. Así surgen tres estados posibles,
   * cada uno indica que acciones se ejecutan cuando cambia el estado del partido.
   * Determinan las acciones posibles en cada estado.
   *
   *
   */

  /*
   * Metodos que retornan info del partido
   */


  // Retorna el competidor Local
  public Competidor getLocal() {
    return (this.local);
  }

  // Retorna el competidor Visitante
  public Competidor getVisitante() {
    return (this.visitante);
  }

//Retorna el lugar de Juego
 public String getLugarDeJuego() {
	  return (this.lugar);
 }

 // Retorna True si el competidor participa
 public Boolean juega(Competidor competidor){
   return(this.getLocal() == competidor || this.getVisitante() == competidor);
 }

 // Retorna True si el partido es entre ambos competidores (cLocal y cVisitante en cualquier orden)
 public Boolean juegan(Competidor cLocal, Competidor cVisitante){
   return(this.getLocal() == cLocal && this.getVisitante() == cVisitante|| this.getVisitante() == cLocal && this.getLocal() == cVisitante);
 }

 // Retorna True si gana local status actual
 public Boolean ganaLocal() {
	  return (this.resultado.ganaCompetidor() == this.getLocal());
 }

 // Retorna True si gana visitante status actual
 public Boolean ganaVisitante() {
	  return (this.resultado.ganaCompetidor() == this.getVisitante());
 }

 // Retorna la Fecha de Juego
 public Date getFecha() {
	return fecha;
 }

 // Retorna True si el partido conrresponde al deporte dDeporte
 public boolean esDeporte(Deporte dDeporte) {
	return (this.deporte.esDeporte(dDeporte));
 }

 // Retorna True si el cCompetidor es Local
 public boolean esLocal(Competidor cCompetidor) {
	return (this.getLocal() == cCompetidor);
 }

 // Retorna True si cCompetidor es Visitante
 public boolean esVisitante(Competidor cCompetidor) {
	return (this.getVisitante() == cCompetidor);
 }

	public Deporte getDeporte() {
		return this.deporte;
	}

	public boolean huboEmpate() {
		return this.getEstado().resultadoPartido(this).empate();
	}

  // Retorna estado del partido
  public EstadoPartido getEstado() {
    return (this.estado);
  }

  /*
   * Metodos setters
   */

  // Setea el estado del partido y handlea acciones que deben darse cuando cambia al nuevo estado
  public void setEstado(EstadoPartido estadoNew) {
	  this.estado = estadoNew;
	  this.estado.accionar(this);
  }

  public void setResultado(Resultado resultadoPartido) {
	  this.resultado = resultadoPartido;
  }




  /*
   * Metodos que dependen del estado del partido, y por ello se delegan en el mismo.
   *
   */
  
  
  public void addApuesta(Evento evento, Usuario usuario, OpcionApuesta opcionApuesta, double monto, boolean esSegura) throws Exception {
		try {
		this.estado.addApuesta(evento, usuario, opcionApuesta, monto, esSegura);
		} catch (Exception e) {
			System.out.println("El evento ya no permite hacer apuestas.");
			e.printStackTrace();
			throw new Exception("Ya no es posible hacer apuestas", e);
		}
	}


  // Delega el mensaje a su estado interno y retorna el resultado actual del partido
  public Resultado getResultado() {
	  return this.getEstado().resultadoPartido(this);
  }

  // Retorna el resultado, es invocado por su estado interno
  public Resultado resultado() {
	  return (this.resultado);
  }
  
  //metodo invocado por el usuario
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception {
		this.estado.cancelarApuestaSegura(apuestaACancelar);
	}

	// Reactiva una apuesta ya cancelada. Cambia el estado de la apuesta: se activa.
			// Invariante: se debe tratar de una apuesta cancelada.
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception {
		this.estado.reactivarApuestaSegura(apuestaAReactivar);
	}




  /*
   * Implementa metodos de notificacion a subscriptores (como CasaApuestas)
   */

	public void notificarFinalSubscriptores() {
		this.subscriptores.forEach(subscriptor->subscriptor.updateFinalPartido());
	}


	public void addSubscriptor(ISubscriptorPartido subscriptor) {
		this.subscriptores.add(subscriptor);

	}


	public boolean enCurso() {

		return this.estado instanceof EnCurso;
	}


	public boolean finalizado() {
		return this.estado instanceof Finalizado;
	}

	public Date getFechaDate() {
		return (this.fecha);
	}

	public ArrayList<ISubscriptorPartido> getSubscriptores(){
		return(this.subscriptores);
	}


	public void notificarInicioSubscriptores() {
		this.subscriptores.forEach(subscriptor->subscriptor.updateInicioPartido());	
	}


	
}
