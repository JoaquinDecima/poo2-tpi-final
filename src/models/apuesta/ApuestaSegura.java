package apuesta;

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

	@Override
	public
	Double ganaciaBruta() {
		//TODO:retornar excepcion si el partido aun no finalizo
		return this.gananciaBruta;
	}

	@Override
	public
	Double ganaciaNeta() {
		//TODO:retornar excepcion si el partido aun no finalizo
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


	public Evento getEvento() {
		
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

	@Override
	public void setGananciaBruta(Double monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGananciaNeta(Double monto) {
		// TODO Auto-generated method stub
		
	}
	
}
