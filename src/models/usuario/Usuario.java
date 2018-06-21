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

	
	/* 
	 * metodos sobre apuestas seguras 
	 */
	
	// usuario crea apuesta solo si el partido no ha comenzado. Accion que se delega en el evento.
	public void hacerApuestaSegura(Evento evento, OpcionApuesta opcionApuesta, double monto) {		
		try {
			evento.addApuestaSegura(this, opcionApuesta, monto);
			this.decrementarMontoWallet(monto);
		} catch (Exception e) {
			System.out.println("El evento ya no permite hacer apuestas.");
			e.printStackTrace();		
		}	
	}

	public void cancelarApuesta(ApuestaSegura apuestaACancelar) {
		try {
			apuestaACancelar.getEvento().cancelarApuestaSegura(apuestaACancelar);
		} catch (Exception e) {
			System.out.println("Una apuesta no puede ser cancelada si el partido ha finalizado.");
			e.printStackTrace();
		}	
	}

	public void reactivarApuesta(ApuestaSegura apuestaAReactivar) {
		try {
			apuestaAReactivar.getEvento().reactivarApuestaSegura(apuestaAReactivar);
		} catch (Exception e) {
			System.out.println("Una apuesta solo puede ser reactivada si el partido aún no ha comenzaado.");
			e.printStackTrace();
		}	
	}
}
