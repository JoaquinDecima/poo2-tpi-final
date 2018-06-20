package usuario;


import apuesta.*;
import apuesta.OpcionApuesta;
import evento.Evento;


public class Usuario {

	private String nombre;

	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void incrementarMontoWallet(int i) {
		// TODO Auto-generated method stub
		
	}

	public String getMontoWallet() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApuestaSegura hacerApuestaSegura(Evento evento, OpcionApuesta opcionApuesta, double monto) {
		
		ApuestaSegura apuesta = new ApuestaSegura(this, evento, opcionApuesta, monto);

		
		return apuesta;
	}

	public void cancelarApuesta() {
		// TODO Auto-generated method stub
		
	}

}
