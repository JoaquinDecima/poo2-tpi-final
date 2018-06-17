package apuesta;

import evento.Evento;
import usuario.Usuario;

public class ApuestaSegura extends Apuesta {
	
	public ApuestaSegura(Usuario u, Evento e, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.evento = e;
		this.monto = m;
		this.apuesta = op;
	}

	@Override
	float ganaciaBruta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	float ganaciaNeta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	Double montoApostado() {
		return monto;
	}

	@Override
	OpcionApuesta opcionApostada() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelarApuesta() {
		
	}
	
	public void reactivarApuesta() {
		
	}
	
}
