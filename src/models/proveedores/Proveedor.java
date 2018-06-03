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
import models.competidor.*;
import models.deporte.*;
import models.juego.*;

/*
 * La Siguiente clase Represnta una API que funciona como medio para obtener datos
 * de los partidos. La misma se puede comparar, por ejemplo, con Ole y otras APIs
 * que se encargan de mantener esta clase de datos.
 */

public class Proveedor {
  private ProveedorDePartido partidos;
  private ProveedorDeEstadistica estadistica;

  // El constructor de la API setea de donde consultara los datos (Pueden haber diferentes proveedores)
  public Proveedor(ProveedorDePartido pPartidos, ProveedorDeEstadistica pEstadistica){
    this.partidos = pPartidos;
    this.estadistica = pEstadistica;
  }

  
  // Retorna una Lista de Partidos sin filtro
  public ArrayList<Partido> getPatridosAll(){
    return(this.partidos.getPatridosAll());
  }

  
  // Retorna una lista de partidos del deporte "dDeporte"
  public ArrayList<Partido> getPartidosDeDeporte(Deporte dDeporte){
    return(this.partidos.getPartidosDeDeporte(dDeporte));
  }

  
  // Retorna todos los partidos que se juegen en dDate
  public ArrayList<Partido> getPartidosDeFecha(Date dDate){
    return(this.partidos.getPartidosDeFecha(dDate));
  }

  
  // Retorna la cantidad de Victorias de cCompetidor en iPartidos cantidad de partidos
  public int victoriasDeEnPartidos(Competidor cCompetidor, int iPartidos) { 
	  return(this.estadistica.victoriasDe(cCompetidor, iPartidos, this.getPartidosDeDeportista(cCompetidor)));
  }
  
  
	//Retorna la cantidad de Victorias de los competidores en iPartidos cantidad de partidos
	 public int victoriasDeEnPartidos(Competidor cLocal, Competidor cVisitante, int iPartidos) { 
		  return(this.estadistica.victoriasDe(cLocal, iPartidos, this.getPartidosDeDeportistas(cLocal, cVisitante)));
	 }	
  
	 
  // Retorna la cantidad de empates
  public int empatesDeEnPartidos(Competidor cCompetidor, int iPartidos) {
	  return(this.estadistica.empatesDe(this.getPartidosDeDeportista(cCompetidor), iPartidos));
  }
  

  //Retorna la cantidad de empates de 2 competidores
  public int empatesDeEnPartidos(Competidor cLocal, Competidor cVisitante, int iPartidos) {
	  return(this.estadistica.empatesDe(this.getPartidosDeDeportistas(cLocal, cVisitante), iPartidos));
  }
  
  /*
   * Se toma la decicion de que la implementacion de la API de los proveedores
   * es quien tiene la obligacion de manipular los datos dado que que los
   * proveedores solo pueden dar la cantidad minima de datos necesarios. Los
   * demas debe reconstruirlos mediante lo obtenido la implementacion. En este
   * caso es esta capa quien lo hara
   *
   * De aqui en adelante veremos como esta implementacion manipula los datos
   * lo anterior solo es el intermediario de la comunicacion.
   */

  
  // Retorna una lista de De partidos en la que participio "cCompetidor"
  public ArrayList<Partido> getPartidosDeDeportista(Competidor cCompetidor){     //Recordar ver interface de Competidor
    ArrayList<Partido> listPartidos = new ArrayList<Partido>();

    // Recorro los partidos
    for (Partido p : this.getPatridosAll()){
      //Si el competidor Participa (juega)
      if (p.juega(cCompetidor)){
        // Lo sumo a la lista
        listPartidos.add(p);
      }
    }
    return(this.corregirLista(listPartidos));
  }
  
  
  // Retorna la canteidad de Partidos entre cLocal y cVisitante
  public int cantDePartidosEntre(Competidor cLocal, Competidor cVisitante) {
	  return(this.getPartidosDeDeportistas(cLocal, cVisitante).size());
  }

  
  // Retorna una lista de De partidos en la que participio "cCompetidor"
  public ArrayList<Partido> getPartidosDeDeportistas(Competidor cLocal, Competidor cVisitante){     //Recordar ver interface de Competidor
    ArrayList<Partido> listPartidos = new ArrayList<Partido>();

    // Recorro los predates
    for (Partido p : this.getPatridosAll()){
      //Si el competidor Participa (juega)
      if (p.juegan(cLocal, cVisitante)){
        // Lo sumo a la lista
        listPartidos.add(p);
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
   protected ArrayList<Partido> corregirLista(ArrayList<Partido> lList){
     ArrayList<Partido> listPartidos = new ArrayList<Partido>();
     for (Partido p : lList){
       listPartidos.add(p);
     }
     return(listPartidos);
   }
   
   
}
