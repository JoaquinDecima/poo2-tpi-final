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

package juego;

import java.util.ArrayList;
// Importa utilidades Java
import java.util.Date;

import competidor.Competidor;
import deporte.Deporte;
import juego.estado.EnCurso;
import juego.estado.EstadoPartido;
import juego.estado.Finalizado;
import juego.estado.Proximo;
import juego.resultado.Resultado;

public class Partido{
  private Competidor local;
  private Competidor visitante;
  private Deporte deporte;
  private Date fecha;
  private String lugar;
  private EstadoPartido estado;
  private Resultado resultado;
  private ArrayList<ISubscriptorPartido> subscriptores; 


  public Partido(Competidor cLocal, Competidor cVisitante, Deporte dDeporte, Date dFecha, String sLugar) {
    this.local = cLocal;
    this.visitante = cVisitante;
    this.deporte = dDeporte;
    this.fecha = dFecha;
    this.lugar = sLugar;
    this.estado = new Proximo();
  }

  // Retrona el competidor Local
  public Competidor getLocal() {
    return (this.local);
  }
  
  // Retorna el competidor Visitante
  public Competidor getVisitante() {
    return (this.visitante);
  }

  // Retorna estado del partido
  public EstadoPartido getEstado() {
    return (this.estado);
  }
  
  // Setea el estado del partido y handlea acciones que deben darse cuando cambia al nuevo estado
  public void setEstado(EstadoPartido estadoNew) {
	  this.estado = estadoNew;
	  this.estado.accionar();
  }
  
  // Delega el mensaje a su estado interno
  public Resultado getResultado() {
	  return this.estado.resultadoPartido(this);
  }

  public void setResultado(Resultado resultadoPartido) {
	  this.resultado = resultadoPartido;
  }
  
  // Retorna el lugar de Juego
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

  // Retorna True si gana local 
  public Boolean ganaLocal() {
	  return (this.resultado.ganaCompetidor() == this.getLocal());
  }
  
  // Retorna True si gana visitante
  public Boolean ganaVisitante() {
	  return (this.resultado.ganaCompetidor() == this.getVisitante());
  }

  
  // Retorna la Fecha de Juego
  public int getFecha() {
	return fecha.getDate();
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

	public boolean enCurso() {
		return this.getEstado() instanceof EnCurso;
	} 
	
	public boolean esProximo() {
		return this.getEstado() instanceof Proximo;	
	}
	
	public boolean finalizado() {
		return this.getEstado() instanceof Finalizado;	
	}
	
	// Implementa metodos de notificacion a subscriptores (como CasaApuestas)

	public void notificarFinalSubscriptores() {
		this.subscriptores.forEach(subscriptor->subscriptor.updateFinalPartido());
	}
	

	public void addSubscriptor(ISubscriptorPartido subscriptor) {
		this.subscriptores.add(subscriptor);
		
	}

	public Deporte getDeporte() {
		
		return this.deporte;
	}

	public boolean huboEmpate() {
		return this.resultado.empate();
	}
}




