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

package models.cuota;

// Se importa de Modelos
import models.juego.Partida;
import models.posibilidad.*;
import models.proveedores.*;
import models.posibilidad.*;

public class Cuota {
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaDeVictoriaLocal(Partida pPartido, Proveedor pProveedor, Posibilidad pPosibilidad) {
		return(pPosibilidad.getPosibilidadDeVictoriaLocal(pPartido, pProveedor) + 1);
	}
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaDeVictoriaVisitante(Partida pPartido, Proveedor pProveedor, Posibilidad pPosibilidad) {
		return(pPosibilidad.getPosibilidadDeVictoriaVisitante(pPartido, pProveedor) + 1);
	}
	
	// Retorna la posibilidad de empate de un equipo
	public double getCuotaDeEmpate(Partida pPartido, Proveedor pProveedor, Posibilidad pPosibilidad) {
		return(pPosibilidad.getPosibilidadDeEmpate(pPartido, pProveedor) + 1);
	}
}
