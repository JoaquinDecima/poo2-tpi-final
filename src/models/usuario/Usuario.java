package usuario;


import apuesta.*;
import apuesta.OpcionApuesta;
import evento.Evento;


public class Usuario {

	private String nombre;
	private Double wallet;

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.wallet = 0.00;
		
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void incrementarMontoWallet(Double monto) {
		this.wallet = this.wallet + monto;	
	}
	
	public void decrementarMontoWallet(Double monto) {
		this.wallet = this.wallet - monto;			
	}

	public Double getMontoWallet() {
		return wallet;
	}

	public ApuestaSegura hacerApuestaSegura(Evento evento, OpcionApuesta opcionApuesta, double monto) {
		
		ApuestaSegura apuesta = evento.addApuestaSegura(this, opcionApuesta, monto);
		this.decrementarMontoWallet(monto);
		return apuesta;
	}

	public void cancelarApuesta(ApuestaSegura apuestaACancelar) {
		apuestaACancelar.getEvento().cancelarApuestaSegura(apuestaACancelar);
	
	}

	public void reactivarApuesta(ApuestaSegura apuestaAReactivar) {
		apuestaAReactivar.getEvento().reactivarApuestaSegura(apuestaAReactivar);
	
	}
}
