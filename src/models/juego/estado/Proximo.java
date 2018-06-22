package juego.estado;

import juego.Partido;
import juego.resultado.Resultado;

public class Proximo implements EstadoPartido {

	@Override
	public Resultado resultadoPartido(Partido partido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
	
	// Retorna el estado del partido
	// Importante para Test
	public String getEstado() {
		return("Proximo");
	}
}
//devuelve resultado nll object