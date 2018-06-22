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
	Double ganaciaBruta() {
		// TODO: Implementar
		return this.gananciaBruta;
	}

	@Override
	public
	Double ganaciaNeta() {
		// TODO: Implementar
		return this.gananciaNeta;
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

	@Override
	public void setGananciaBruta(Double monto) {
		this.gananciaBruta = monto;	
	}

	@Override
	public void setGananciaNeta(Double monto) {
		this.gananciaNeta = monto;
	}

}
