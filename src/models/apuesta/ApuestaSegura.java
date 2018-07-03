package models.apuesta;

import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public class ApuestaSegura extends Apuesta {

	// con esta variable se lleva registro de todas las apuestas, incluso las canceladas
	private boolean estaActiva;

	public ApuestaSegura(Evento evento, Usuario u, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.monto = m;
		this.apuesta = op;
		this.estaActiva = true;
		this.evento = evento;
	}

	public boolean estaActiva() {
		return this.estaActiva;
	}

	public void updateEstado() {
		this.estaActiva = !this.estaActiva;
	}

	
}
