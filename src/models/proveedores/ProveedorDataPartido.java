package proveedores;

import java.util.ArrayList;

import juego.Partido;
import juego.estado.EnCurso;
import juego.estado.Finalizado;

public class ProveedorDataPartido {
	
	private ArrayList<Partido> partidos;
	private CalculadorEstadisticas estadisticas;
	
	
	public ProveedorDataPartido() {
		this.partidos = new ArrayList<Partido>();
		this.estadisticas = new CalculadorEstadisticas();	
	}
	
	public void finalizarPartido(Partido p) {
		p.setEstado(new Finalizado());
	}
	
	public void iniciarPartido(Partido p) {
		p.setEstado(new EnCurso());
	}

}
