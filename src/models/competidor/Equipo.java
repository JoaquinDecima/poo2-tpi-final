package models.competidor;

// Importa Utilidades Java
import java.util.ArrayList.*;

// Importa del Modelo
import models.competidor.Deportista.*;

public class Equipo(){
  protected ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
  protected String nombreEquipo;

  // Retorna el nombre del Equipo
  public String getNombre(){
    return(this.nombreEquipo);
  }
}
