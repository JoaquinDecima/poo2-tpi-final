package apuesta;

import evento.Evento;
import usuario.Usuario;

class ApuestaFinal extends Apuesta {
	
	

	@Override
	Double montoApostado() {
		return this.monto;
	}

	@Override
	OpcionApuesta opcionApostada() {
		return this.apuesta;
	}

	@Override
	Evento getEvento() {
		return this.evento;
	}

	@Override
	Double ganaciaBruta() {
		return this.gananciaBruta;
	}

	@Override
	Double ganaciaNeta() {
		return this.gananciaNeta;
	}

	@Override
	Usuario getUsuario() {
		return this.usuario;
	}

}
