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
