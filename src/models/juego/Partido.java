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

// Importa utilidades Java
import java.util.Date;

// Importa de Mi modelo
import models.competidor.*;
import models.deporte.Deporte;
import models.juego.estado.*;

public class Partido{
  protected Competidor local;
  protected Competidor visitante;
  protected Deporte deporte;
  protected Date fecha;
  protected String lugar;
  protected Estado estado;

  public Partido(Competidor cLocal, Competidor cVisitante, Deporte dDeporte, Date dFecha, String sLugar) {
    this.local = cLocal;
    this.visitante = cVisitante;
    this.deporte = dDeporte;
    this.fecha = dFecha;
    this.lugar = sLugar;
  }

  // Retrona el competidor Local
  public Competidor getLocal(){
    return (this.local);
  }
  
  // Retorna el lugar de Juego
  public String getLugarDeJuego() {
	  return(this.lugar);
  }
  
  // Retrona el competidor Visitante
  public Competidor getVisitante(){
    return (this.visitante);
  }

  // Retrona el estado
  public Estado getEstado(){
    return(this.estado);
  }

  // Retrona la fecha de Juego
  @SuppressWarnings("deprecation")
public int getFechaDeJuego(){
    return(this.fecha.getDate());
  }

  // Retorna True si el competidor participa
  public Boolean juega(Competidor competidor){
    return(this.getLocal() == competidor || this.getVisitante() == competidor);
  }

  // Retorna True si el partido es entre ambos competidores (cLocal y cVisitante en cualquier orden)
  public Boolean juegan(Competidor cLocal, Competidor cVisitante){
    return(this.getLocal() == cLocal && this.getVisitante() == cVisitante|| this.getVisitante() == cLocal && this.getLocal() == cVisitante);
  }
  
  // Retorna true si dDeporte es el deporte
  public Boolean esDeporte(Deporte dDeporte) {
	  return(this.deporte.esDeporte(dDeporte));
  }
  
  // Retorna True si gano local 
  // TODO: Falta implementar
  public Boolean ganoLocal() {
	  return(false);
  }
  
  //Retorna True si gano visitante
  //TODO: Falta implementar
  public Boolean ganoVisitante() {
	  return(false);
  }
 
  // Retorna True si empataron
  //TODO: Falta implementar
  public Boolean empato() {
	  return(this.deporte.permiteEmpate() && false);
  }

  // Retorna true si cOponente es Local
  public Boolean esLocal(Competidor cOponente) {
	  return(this.local == cOponente);
  }
  
//Retorna true si cOponente es Visitante
  public Boolean esVisitante(Competidor cOponente) {
	  return(this.local == cOponente);
  }
}
