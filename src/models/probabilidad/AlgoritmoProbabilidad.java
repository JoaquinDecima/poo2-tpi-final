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

package models.probabilidad;

// Se importa Modelo
import models.juego.*;
import models.proveedores.*;

public interface AlgoritmoProbabilidad {
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getPosibilidadDeVictoriaLocal(Partido pPartido, Proveedor pProveedor);
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getPosibilidadDeVictoriaVisitante(Partido pPartido, Proveedor pProveedor);
	
	// Retorna la posibilidad de empate de un equipo
	public double getPosibilidadDeEmpate(Partido pPartido, Proveedor pProveedor);
}
