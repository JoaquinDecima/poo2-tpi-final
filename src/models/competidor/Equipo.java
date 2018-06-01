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
import java.util.ArrayList;

// Importa del Modelo
import models.competidor.Deportista;

public class Equipo implements Competidor{
  protected ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
  protected String nombreEquipo;

  public Equipo(String sNombre, ArrayList<Deportista> aList) {
	  this.nombreEquipo = sNombre;
	  this.deportistas = aList;
  }
  
  // Retorna el nombre del Equipo
  public String getNombre(){
    return(this.nombreEquipo);
  }
  
  // Retorna cantidad de Jugadores
  public int getCantDeJugadores() {
	  return(this.deportistas.size());
  }
  
  //Agrega un jugador al Equipo
  public void addJugador(Deportista djugador) {
	  this.deportistas.add(djugador);
  }
}
