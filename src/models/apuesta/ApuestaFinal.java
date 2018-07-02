package models.apuesta;

import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public class ApuestaFinal extends Apuesta {

	public ApuestaFinal(Usuario u, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.evento = op.getEvento();
		this.monto = m;
		this.apuesta = op;
	}
}
