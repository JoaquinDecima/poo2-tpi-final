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

package models.proveedores;

// Importa utilidades Java
import java.util.ArrayList;
import java.util.Date;

// Importa del Modelo
import models.deporte.Deporte.*;
import models.juego.Partida.*;

/*
 * Se encuentra aqui el controlador y gestor de partido Oficial utilizado por
 * millones de sitios web para obtener todos los partidos. Cumple con algunas
 * funciones basicas que le permiten a los sitios obtener distintos datos
 */
public class ProveedorDePartido {
  protected ArrayList<Partida> partidos = new ArrayList<Partida>();

  // Retorna una Lista de Partidos sin filtro
  public ArrayList<Partida> getPatridosAll(){
    return(this.partidos);
  }

  // Retorna una lista de partidos del deporte "dDeporte"
  public ArrayList<Partida> getPartidosDeDeporte(Deporte dDeporte){
    private ArrayList<Partida> listPartidos = new ArrayList<Partida>();

    // Recorro los partidos
    for (Partida p : this.getPatridosAll()){
      //Si el partido es de "dDeporte" deporte
      if (p.esDeporte(dDeporte)){
        // Lo sumo a la lista
        lsitPartidos.add(p);
      }
    }
    return(this.corregirLista(listPartidos));
  }

  // Retorna todos los partidos que se juegen en dDate
  public ArrayList<Partida> getPartidosDeFecha(Date dDate){
    private ArrayList<Partida> listPartidos = new ArrayList<Partida>();

    // Recorro los partidos
    for (Partida p : this.getPatridosAll()){
      //Si el partido es de "dDeporte" deporte
      if (p.getFechaDeJuego() == dDate.getDate()){
        // Lo sumo a la lista
        lsitPartidos.add(p);
      }
    }
    return(this.corregirLista(listPartidos));
  }

  /*
   * Funcionalidades adicionales para corregir problemas de implementacion, se
   * desarrollan con el fin de seguir la logica que se viene aplicando. Esta
   * seccion no tiene codigo relevante solo correcciones que se aplicaran a
   * nuestras implementaciones.
   */

   // Invierte el orden de las listas para corregir la iteracion realizada
   protected ArrayList<Partida> corregirLista(ArrayList<Partida> lList){
     private ArrayList<Partida> listPartidos = new ArrayList<Partida>();
     for (Partida p : lList){
       listPartidos.add(p);
     }
     return(listPartidos);
   }
}
