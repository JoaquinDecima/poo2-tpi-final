package juego.estado;

import juego.Partido;
import juego.resultado.Resultado;

public class Finalizado implements EstadoPartido {
	
	@Override
	public Resultado resultadoPartido(Partido partido) {
		return partido.getResultado();		
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
	
	// Retorna el estado del partido
	// Importante para Test
	public String getEstado() {
		return("Finalizado");
	}
}
