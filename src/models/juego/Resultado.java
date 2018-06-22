package juego;

import competidor.Competidor;

public abstract class Resultado {
	
	private Competidor gana;
	private Competidor pierde;
	
	
	public Competidor ganaCompetidor() {
		return this.gana;	
	}
	
	public Competidor pierdeCompetidor() {
		return this.pierde;	
	}

	
	

}
