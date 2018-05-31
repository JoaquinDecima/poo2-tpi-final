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
  public ArrayList<Partida> getPatridosAll(){
    return(this.partidos.getPatridosAll());
  }

  // Retorna una lista de partidos del deporte "dDeporte"
  public ArrayList<Partida> getPartidosDeDeporte(Deporte dDeporte){
    return(this.partidos.getPartidosDeDeporte(dDeporte));
  }

  // Retorna todos los partidos que se juegen en dDate
  public ArrayList<Partida> getPartidosDeFecha(Date dDate){
    return(this.partidos.getPartidosDeFecha(dDate));
  }
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
  public ArrayList<Partida> getPartidosDeDeportista(Competidor cCompetidor){     //Recordar ver interface de Competidor
    private ArrayList<Partida> listPartidos = new ArrayList<Partida>();

    // Recorro los partidos
    for (Partida p : this.getPatridosAll()){
      //Si el competidor Participa (juega)
      if (p.juega(cCompetidor)){
        // Lo sumo a la lista
        listPartidos.add(p);
      }
    }
    return(listPartidos);
  }

  // Retorna una lista de De partidos en la que participio "cCompetidor"
  public ArrayList<Partida> getPartidosDeDeportistas(Competidor cLocal, Competidor cVisitante){     //Recordar ver interface de Competidor
    private ArrayList<Partida> listPartidos = new ArrayList<Partida>();

    // Recorro los partidos
    for (Partida p : this.getPatridosAll()){
      //Si el competidor Participa (juega)
      if (p.juegan(cLocal, cVisitante)){
        // Lo sumo a la lista
        listPartidos.add(p);
      }
    }
    return(listPartidos);
  }
}
