package apuesta;

import apuesta.opcion.OpcionApuesta;
import evento.Evento;
import juego.Partido;
import usuario.Usuario;

public class ApuestaFinal extends Apuesta {
	
	public ApuestaFinal(Usuario u, Evento e, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.evento = e;
		this.monto = m;
		this.apuesta = op;
	}
}
