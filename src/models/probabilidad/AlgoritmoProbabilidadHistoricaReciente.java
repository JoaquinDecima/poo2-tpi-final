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

import models.juego.Partido;
import models.proveedores.Proveedor;

// Error en implementacion cuenta con 10% de Margen de Error
public class AlgoritmoProbabilidadHistoricaReciente implements AlgoritmoProbabilidad {

	@Override
	public double getPosibilidadDeVictoriaLocal(Partido pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getLocal(), 10) / 10);
	}

	@Override
	public double getPosibilidadDeVictoriaVisitante(Partido pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getVisitante(), 10) / 10);
	}

	@Override
	public double getPosibilidadDeEmpate(Partido pPartida, Proveedor pProveedor) {
		return (((pProveedor.empatesDeEnPartidos(pPartida.getLocal(), 10) / 10) + (pProveedor.empatesDeEnPartidos(pPartida.getVisitante(), 10) / 10)) / 2);
	}
	
}
