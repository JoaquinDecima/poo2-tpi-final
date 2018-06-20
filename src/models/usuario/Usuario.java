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

	public void incrementarMontoWallet(int i) {
		// TODO Auto-generated method stub
		
	}

	public Double getMontoWallet() {
		return wallet;
	}

	public ApuestaSegura hacerApuestaSegura(Evento evento, OpcionApuesta opcionApuesta, double monto) {
		
		ApuestaSegura apuesta = new ApuestaSegura(this, evento, opcionApuesta, monto);

		
		return apuesta;
	}

	public void cancelarApuesta() {
		// TODO Auto-generated method stub
		
	}

}
