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
import models.juego.Partido;
import models.probabilidad.*;
import models.proveedores.*;

public class AdminCuota {
	protected Proveedor pProveedor;
	protected AlgoritmoProbabilidad pPosibilidad;
	
	public AdminCuota(Proveedor prove, AlgoritmoProbabilidad proba) {
		this.pProveedor = prove;
		this.pPosibilidad = proba;
	}
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaDeVictoriaLocal(Partido pPartido) {
		return(pPosibilidad.getPosibilidadDeVictoriaLocal(pPartido, pProveedor) + 1);
	}
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaDeVictoriaVisitante(Partido pPartido) {
		return(pPosibilidad.getPosibilidadDeVictoriaVisitante(pPartido, pProveedor) + 1);
	}
	
	// Retorna la posibilidad de empate de un equipo
	public double getCuotaDeEmpate(Partido pPartido) {
		return(pPosibilidad.getPosibilidadDeEmpate(pPartido, pProveedor) + 1);
	}
}
