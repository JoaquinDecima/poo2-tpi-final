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

package models.posibilidad;

import models.juego.Partida;
import models.proveedores.Proveedor;

// Por error de implementaicon cuenta con margen de error inversamente propocional a la cantidad de partidos jugados
public class PosibilidadHistoricaDirecta implements Posibilidad {

	@Override
	public double getPosibilidadDeVictoriaLocal(Partida pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getLocal(), pPartida.getVisitante(), pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante())) / pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante()));
	}

	@Override
	public double getPosibilidadDeVictoriaVisitante(Partida pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getVisitante(), pPartida.getLocal(), pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante())) / pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante()));
	}

	@Override
	public double getPosibilidadDeEmpate(Partida pPartida, Proveedor pProveedor) {
		return (pProveedor.empatesDeEnPartidos(pPartida.getLocal(), pPartida.getVisitante(), pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante())) / pProveedor.cantDePartidosEntre(pPartida.getLocal(), pPartida.getVisitante()));
	}

}