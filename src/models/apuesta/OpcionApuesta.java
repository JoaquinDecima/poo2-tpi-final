

package apuesta;

import juego.resultado.Resultado;

public class OpcionApuesta {
	
	private Resultado resultado;
	private Double cuota;
	
	public OpcionApuesta(Resultado resultadoPosible, Double cuotaASetear) {
		this.resultado = resultadoPosible;
		this.cuota = cuotaASetear;		
	}

	public Resultado resultado() {
		return this.resultado;
	}
	
	public Double cuota() {
		return this.cuota;
	}
	

}
