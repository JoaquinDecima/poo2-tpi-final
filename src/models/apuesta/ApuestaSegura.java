package apuesta;

import evento.Evento;
import juego.Partido;
import usuario.Usuario;

public class ApuestaSegura extends Apuesta {
	
	// con esta variable se lleva registro de todas las apuestas, incluso las canceladas
	private boolean estaActiva;
	
	public ApuestaSegura(Usuario u, OpcionApuesta op, Double m) {
		this.usuario = u;
		this.evento = op.getEvento();
		this.monto = m;
		this.apuesta = op;
		this.estaActiva = true;
	}

	@Override
	public
	Double ganaciaBruta() {
		return this.gananciaBruta;
	}

	@Override
	public
	Double ganaciaNeta() {
		return this.ganaciaNeta();
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
	
	public boolean estaActiva() {
		return this.estaActiva;
	}
	
	public void updateEstado() {
		this.estaActiva = !this.estaActiva;
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
	
	

	public void cambiarStatus() {
		this.estaActiva = false;
		
	}

	@Override
	public Evento getEvento() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
