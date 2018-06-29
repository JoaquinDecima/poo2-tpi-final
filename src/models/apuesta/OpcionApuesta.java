

package apuesta;

import evento.Evento;
import juego.Partido;
import juego.resultado.Resultado;

public class OpcionApuesta {
	
	private Resultado resultado;
	private Double cuota;
	private Evento evento;
	
	public OpcionApuesta(Partido partido, Resultado resultadoPosible, Double cuotaASetear) {
		this.resultado = resultadoPosible;
		this.cuota = cuotaASetear;		
	}

	public Resultado resultado() {
		return this.resultado;
	}
	
	public Double cuota() {
		return this.cuota;
	}
	
	public Partido getPartido() {
		return this.evento.getPartidoDelEvento();
	}

	public Evento getEvento() {
		return evento;
	}


}
