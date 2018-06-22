package apuesta;

import evento.Evento;
import juego.Partido;
import usuario.Usuario;

class ApuestaFinal extends Apuesta {
	
	

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
		return this.gananciaBruta;
	}

	@Override
	public
	Double ganaciaNeta() {
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
