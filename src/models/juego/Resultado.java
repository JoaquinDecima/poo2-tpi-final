package juego;

import competidor.Competidor;

public class Resultado {
	
	private Competidor gana;
	private Competidor pierde;
	private boolean empate;
	
	public Resultado(Competidor competidorGana, Competidor competidorPierde) {
		this.gana = competidorGana;
		this.pierde = competidorPierde;	
	}
	
	public Competidor ganaCompetidor() {
		return this.gana;	
	}
	
	public Competidor pierdeCompetidor() {
		return this.pierde;	
	}

	public boolean empate() {
		return empate;
	}
	
	

}
