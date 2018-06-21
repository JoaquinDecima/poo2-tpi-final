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
		// TODO Auto-generated method stub
		return null;
	}

}
