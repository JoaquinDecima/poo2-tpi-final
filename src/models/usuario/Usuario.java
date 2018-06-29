package models.usuario;


import models.apuesta.*;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;


public class Usuario {

	private String nombre;
	private String email;
	private Double wallet;

	public Usuario(String nombre, String sEmail) {
		this.nombre = nombre;
		this.email = sEmail;
		this.wallet = 0.00;

	}

	public String getNombre() {
		return this.nombre;
	}

	// Retorna el email
	public String getEmail() {
		return this.email;
	}

	// Sete nuevo Email
	public void setEmail(String sEmail) {
		this.email = sEmail;
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

	// usuario crea apuesta solo si el partido no ha comenzado. Accion que se delega en el partido, pues
	// depende del estado del mismo.
	public void hacerApuestaSegura(OpcionApuesta opcionApuesta, double monto) {
		try {
			opcionApuesta.getPartido().addApuestaSegura(this, opcionApuesta, monto);
			this.decrementarMontoWallet(monto);
		} catch (Exception e) {
			System.out.println("El evento ya no permite hacer apuestas.");
			e.printStackTrace();
		}
	}

	public void cancelarApuesta(ApuestaSegura apuestaACancelar) {
		try {
			apuestaACancelar.getPartido().cancelarApuestaSegura(apuestaACancelar);
		} catch (Exception e) {
			System.out.println("Una apuesta no puede ser cancelada si el partido ha finalizado.");
			e.printStackTrace();
		}
	}

	public void reactivarApuesta(ApuestaSegura apuestaAReactivar) {
		try {
			apuestaAReactivar.getPartido().reactivarApuestaSegura(apuestaAReactivar);
		} catch (Exception e) {
			System.out.println("Una apuesta solo puede ser reactivada si el partido aún no ha comenzaado.");
			e.printStackTrace();
		}
	}
}
