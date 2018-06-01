package models.posibilidad;

//Se importa Modelo
import models.juego.*;
import models.proveedores.*;

// Error en implementacion cuenta con 10% de Margen de Error
public class PosibilidadHistoriaReciente implements Posibilidad {

	@Override
	public double getPosibilidadDeVictoriaLocal(Partida pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getLocal(), 10) / 10);
	}

	@Override
	public double getPosibilidadDeVictoriaVisitante(Partida pPartida, Proveedor pProveedor) {
		return (pProveedor.victoriasDeEnPartidos(pPartida.getVisitante(), 10) / 10);
	}

	@Override
	public double getPosibilidadDeEmpate(Partida pPartida, Proveedor pProveedor) {
		return (((pProveedor.empatesDeEnPartidos(pPartida.getLocal(), 10) / 10) + (pProveedor.empatesDeEnPartidos(pPartida.getVisitante(), 10) / 10)) / 2);
	}
	
}
