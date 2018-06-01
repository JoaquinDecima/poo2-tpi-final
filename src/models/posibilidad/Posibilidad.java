package models.posibilidad;

// Se importa Modelo
import models.juego.*;
import models.proveedores.*;

public interface Posibilidad {
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getPosibilidadDeVictoriaLocal(Partida p, Proveedor pProveedor);
	
	// Retorna la posibilidad de Victoria de un equipo
	public double getPosibilidadDeVictoriaVisitante(Partida p, Proveedor pProveedor);
	
	// Retorna la posibilidad de empate de un equipo
	public double getPosibilidadDeEmpate(Partida p, Proveedor pProveedor);
}
