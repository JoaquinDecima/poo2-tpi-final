package juego.resultado;

import competidor.Competidor;

public abstract class Resultado {
	
	protected Competidor gana;
	protected Competidor pierde;
	
	
	public Competidor ganaCompetidor() {
		return this.gana;	
	}
	
	public Competidor pierdeCompetidor() {
		return this.pierde;	
	}

	public abstract boolean empate();


}
