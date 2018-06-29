package apuesta;

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
	
	@Override
	public
	Double montoApostado() {
		return this.monto;
	}

	@Override
	public
	OpcionApuesta opcionApostada() {
		return this.apuesta;
	}

	@Override
	public
	Evento getEvento() {
		return this.evento;
	}

	@Override
	public
	Usuario getUsuario() {
		return this.usuario;
	}

	@Override
	public Partido getPartido() {
		return this.evento.getPartidoDelEvento();
	}
}
