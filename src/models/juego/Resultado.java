package models.juego;

import models.competidor.Competidor;

public class Resultado {
	
	private Competidor gana;
	private Competidor pierde;
	
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
	
	

}
