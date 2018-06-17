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

// Importa utilidades Java
import java.util.Date;

import competidor.Competidor;
import deporte.Deporte;
import juego.estado.EstadoPartido;

public class Partido{
  private Competidor local;
  private Competidor visitante;
  private Deporte deporte;
  private Date fecha;
  private String lugar;
  private EstadoPartido estado;
  private Resultado resultado;


  public Partido(Competidor cLocal, Competidor cVisitante, Deporte dDeporte, Date dFecha, String sLugar) {
    this.local = cLocal;
    this.visitante = cVisitante;
    this.deporte = dDeporte;
    this.fecha = dFecha;
    this.lugar = sLugar;
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
  
  // Setea el estado del partido
  public void setEstado(EstadoPartido estadoNew) {
	  this.estado = estadoNew;	  
  }
  
  public Resultado getResultado() {
	  return this.estado.resultadoPartido(this);
  }

  public void setearResultado(Resultado resultadoPartido) {
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

  // Retorna True si empataron
  public Boolean huboEmpate() {
	  return (this.deporte.permiteEmpate() && this.resultado.empate());
  }

public Date getFecha() {
	return fecha;
}


public boolean enCurso() {
	// TODO Auto-generated method stub
	return false;
}
  
}




