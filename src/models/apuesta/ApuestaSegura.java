package apuesta;

import apuesta.opcion.OpcionApuesta;
import evento.Evento;
import juego.Partido;
import usuario.Usuario;

public class ApuestaSegura extends Apuesta {
	
	// con esta variable se lleva registro de todas las apuestas, incluso las canceladas
	private boolean estaActiva;
	
	public ApuestaSegura(Usuario u, Evento e, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.evento = e;
		this.monto = m;
		this.apuesta = op;
		this.estaActiva = true;
	}
	
	public boolean estaActiva() {
		return this.estaActiva;
	}
	
	public void updateEstado() {
		this.estaActiva = !this.estaActiva;
	}
}
