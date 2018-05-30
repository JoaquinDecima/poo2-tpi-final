package models.juego;

// Importa utilidades Java
import java.util.Date;

// Importa de Mi modelo
import models.competidor.Deportista.*;
import models.deporte.Deporte.*;
import models.juego.estados.Estado.*;

public class Partida{
  protected Competidor local;
  protected Competidor visitante;
  protected Deporte deporte;
  protected Date fecha;
  protected String lugar;
  protected Estado estado;

  public Patrida(Competidor cLocal, Competidor cVisitante, Deporte dDeporte, Date dFecha, String sLugar){
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

  // Retrona el competidor Visitante
  public Competidor getVisitante(){
    return (this.visitante);
  }

  // Retrona el estado
  public Estado getEstado(){
    return(this.estado);
  }

  // Retrona la fecha de Juego
  public Date getFechaDeJuego(){
    return(this.fecha.getDate())
  }

  // Retorna True si el competidor participa
  public Boolean juega(Competidor competidor){
    return(this.getLocal == competidor || this.getVisitante == competidor);
  }
}
