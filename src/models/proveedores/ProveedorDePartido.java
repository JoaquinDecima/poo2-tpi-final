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

package proveedores;

// Importa utilidades Java
import java.util.ArrayList;
import java.util.Date;

// Importa del Modelo
import deporte.*;
import juego.*;

/*
 * Se encuentra aqui el controlador y gestor de partido Oficial utilizado por
 * millones de sitios web para obtener todos los partidos. Cumple con algunas
 * funciones basicas que le permiten a los sitios obtener distintos datos
 */
public class ProveedorDePartido {
  protected ArrayList<Partido> partidos = new ArrayList<Partido>();

  // Retorna una Lista de Partidos sin filtro
  public ArrayList<Partido> getPatridosAll(){
    return(this.partidos);
  }

  // Retorna una lista de partidos del deporte "dDeporte"
  public ArrayList<Partido> getPartidosDeDeporte(Deporte dDeporte){
    ArrayList<Partido> listPartidos = new ArrayList<Partido>();

    // Recorro los partidos
    for (Partido p : this.getPatridosAll()){
      //Si el partido es de "dDeporte" deporte
      if (p.esDeporte(dDeporte)){
        // Lo sumo a la lista
        listPartidos.add(p);
      }
    }
    return(this.corregirLista(listPartidos));
  }

  // Retorna todos los partidos que se juegen en dDate
  public ArrayList<Partido> getPartidosDeFecha(Date dDate){
    ArrayList<Partido> listPartidos = new ArrayList<Partido>();

    // Recorro los partidos
    for (Partido p : this.getPatridosAll()){
      //Si el partido es de "dDeporte" deporte
      if (p.getFecha() == dDate.getDate()){
        // Lo sumo a la lista
        listPartidos.add(p);
      }
    }
    return(this.corregirLista(listPartidos));
  }
  
  public ArrayList<Partido> getPartidosQueSeJueguenEn(String sLugar){
	    ArrayList<Partido> listPartidos = new ArrayList<Partido>();

	    // Recorro los partidos
	    for (Partido p : this.getPatridosAll()){
	      //Si el partido es de "dDeporte" deporte
	      if (p.getLugarDeJuego() == sLugar){
	        // Lo sumo a la lista
	        listPartidos.add(p);
	      }
	    }
	    return(this.corregirLista(listPartidos));  
  }
  
  // Agrega Partido
  public void addPartido(Partido p) {
	  this.partidos.add(p);
  }

  /*
   * Funcionalidades adicionales para corregir problemas de implementacion, se
   * desarrollan con el fin de seguir la logica que se viene aplicando. Esta
   * seccion no tiene codigo relevante solo correcciones que se aplicaran a
   * nuestras implementaciones.
   */

   // Invierte el orden de las listas para corregir la iteracion realizada
   protected ArrayList<Partido> corregirLista(ArrayList<Partido> lList){
     ArrayList<Partido> listPartidos = new ArrayList<Partido>();
     for (Partido p : lList){
       listPartidos.add(p);
     }
     return(listPartidos);
   }
}
