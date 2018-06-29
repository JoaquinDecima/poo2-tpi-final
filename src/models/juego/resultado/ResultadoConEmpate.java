package models.juego.resultado;

import models.competidor.Competidor;

public class ResultadoConEmpate extends Resultado {
	
		private boolean empate;

	public ResultadoConEmpate(Competidor competidorGana, Competidor competidorPierde, boolean esEmpate) {
		this.gana = competidorGana;
		this.pierde = competidorPierde;
		this.empate = esEmpate;
		
		
	}
	
	public boolean empate() {
		
		return this.empate;
	}

}
