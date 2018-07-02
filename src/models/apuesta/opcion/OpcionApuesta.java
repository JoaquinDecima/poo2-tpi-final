

package models.apuesta.opcion;

import models.evento.Evento;
import models.juego.Partido;
import models.juego.resultado.Resultado;

public class OpcionApuesta {

	private Resultado resultado;
	private Double cuota;
	private Evento evento;

	public OpcionApuesta(Evento evento, Resultado resultadoPosible, Double cuotaASetear) {
		this.resultado = resultadoPosible;
		this.cuota = cuotaASetear;
		this.evento = evento;
	}

	public Resultado resultado() {
		return this.resultado;
	}

	public Double cuota() {
		return this.cuota;
	}


	public Evento getEvento() {
		return this.evento;
	}
	
	public Partido getPartido() {
		return (this.evento.getPartidoDelEvento());
	}


}
