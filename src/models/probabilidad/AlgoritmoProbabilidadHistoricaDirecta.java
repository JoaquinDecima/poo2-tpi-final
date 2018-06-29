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

// Por error de implementaicon cuenta con margen de error inversamente propocional a la cantidad de partidos jugados
public class AlgoritmoProbabilidadHistoricaDirecta implements AlgoritmoProbabilidad {

	@Override
	public double getPosibilidadDeVictoriaLocal(Partido pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getLocal(), pPartida.getVisitante(), pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante())) / pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante()));
	}

	@Override
	public double getPosibilidadDeVictoriaVisitante(Partido pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getVisitante(), pPartida.getLocal(), pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante())) / pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante()));
	}

	@Override
	public double getPosibilidadDeEmpate(Partido pPartida, Proveedor pProveedor) {
		return (pProveedor.empatesDeEnPartidos(pPartida.getLocal(), pPartida.getVisitante(), pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante())) / pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante()));
	}

}