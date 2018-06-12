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
	protected Proveedor proveedorDataPartidos;
	protected AlgoritmoProbabilidad pPosibilidad;
	
	public AdminCuota(Proveedor proveedorASetear, AlgoritmoProbabilidad algoritmoASetear) {
		this.proveedorDataPartidos = proveedorASetear;
		this.pPosibilidad = algoritmoASetear;
	}
	
	// Pensar como aplicar Template Method
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaPorVictoriaLocal(Partido pPartido) {
		return(pPosibilidad.getPosibilidadDeVictoriaLocal(pPartido, proveedorDataPartidos) + 1);
	}
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaPorVictoriaVisitante(Partido pPartido) {
		return(pPosibilidad.getPosibilidadDeVictoriaVisitante(pPartido, proveedorDataPartidos) + 1);
	}
	
	// Retorna la posibilidad de empate de un equipo
	public double getCuotaPorEmpate(Partido pPartido) {
		return(pPosibilidad.getPosibilidadDeEmpate(pPartido, proveedorDataPartidos) + 1);
	}
}
