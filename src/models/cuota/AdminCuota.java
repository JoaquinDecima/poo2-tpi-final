package cuota;


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


import juego.Partido;
import probabilidad.AlgoritmoProbabilidad;
import proveedores.Proveedor;

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
		return((1 - pPosibilidad.getPosibilidadDeVictoriaLocal(pPartido, proveedorDataPartidos)) + 1);
	}
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getCuotaPorVictoriaVisitante(Partido pPartido) {
		return((1 - pPosibilidad.getPosibilidadDeVictoriaVisitante(pPartido, proveedorDataPartidos)) + 1);
	}
	
	// Retorna la posibilidad de empate de un equipo
	public double getCuotaPorEmpate(Partido pPartido) {
		return((1-pPosibilidad.getPosibilidadDeEmpate(pPartido, proveedorDataPartidos)) + 1);
	}
}
