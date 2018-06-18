package juego.estado;

import juego.Partido;
import juego.Resultado;

public class Finalizado implements EstadoPartido {
	
	@Override
	public Resultado resultadoPartido(Partido partido) {
		return partido.getResultado();		
	}
	


}
