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

import models.competidor.Competidor;
// Importa del Modelo
import models.deporte.Deporte.*;
import models.juego.*;



public class ProveedorDeEstadistica {
	
	// Retorna la cantida de victorias de un competidor
	public int victoriasDe(Competidor cCompetidor, int iCantida, ArrayList<Partido> aList) {
		int sum = 0;
		for (Partido p : this.getPrimeros(iCantida, aList) ) {
			if(p.esLocal(cCompetidor) && p.ganoLocal() || p.esVisitante(cCompetidor) && p.ganoVisitante()) {
				sum += 1;
			}
		}
		return (sum);
	}
	
	// Retorna la cantida de victorias de un competidor
	public int empatesDe(ArrayList<Partido> aList, int iCantidad) {
		int sum = 0;
		for (Partido p : this.getPrimeros(iCantidad, aList)) {
			if(p.empato()) {
				sum += 1;
			}
		}
		return (sum);
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
   
   // Obtiene iNum cantidad de Regiustro de aList
	public ArrayList<Partido> getPrimeros(int iNum, ArrayList<Partido> aList){
		int sum = 0;
		ArrayList<Partido> newList = new ArrayList<Partido>();
		for(Partido p : aList) {
			newList.add(p);
			sum += 1;
			if (sum == iNum) {
				break;
			}
		}
		return(this.corregirLista(newList));
	}
}
