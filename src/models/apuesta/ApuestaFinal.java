package models.apuesta;

import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public class ApuestaFinal extends Apuesta {

	public ApuestaFinal(Evento evento, Usuario u, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.evento = evento;
		this.monto = m;
		this.apuesta = op;
	}
	
	
	
}
