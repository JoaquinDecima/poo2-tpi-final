package juego;

import competidor.Competidor;

public class ResultadoSinEmpate extends Resultado {

	public ResultadoSinEmpate(Competidor competidorGana, Competidor competidorPierde) {
		this.gana = competidorGana;
		this.pierde = competidorPierde;
	}

	@Override
	public boolean empate() {
		return false;
	}

}
