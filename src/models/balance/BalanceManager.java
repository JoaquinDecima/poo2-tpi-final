package models.balance;

import java.util.ArrayList;
import java.util.Date;

import models.apuesta.Apuesta;
import models.tools.EmailBalanceNotifier;
import models.usuario.Usuario;

public class BalanceManager {
	private EmailBalanceNotifier notiEmail = new EmailBalanceNotifier();
	
	// Envia el balace al usuario
	@SuppressWarnings("deprecation")
	public void enviarBalance(Usuario user, ArrayList<Apuesta> apuestas) {
		ArrayList<Apuesta> listaOk = new ArrayList<Apuesta>();
		Date fechaBalance = new Date();
		
		for (Apuesta apuesta : apuestas) {
			// Filtro apuestas del usuario user y del mes actual
			if (this.esDeEsteMes(apuesta) && apuesta.getUsuario() == user) {
				listaOk.add(apuesta);
			}
		}
		
		notiEmail.emailBalance(user.getEmail(), fechaBalance.getMonth(), this.sumaNetos(listaOk));
	}


	private Double sumaNetos(ArrayList<Apuesta> listaOk) {
		double total = 0.0;
		
		for (Apuesta apuesta : listaOk) {
			total += apuesta.gananciaNeta();
		}
		
		return total;
	}


	@SuppressWarnings("deprecation")
	private boolean esDeEsteMes(Apuesta apuesta) {
		Date fechaBalance = new Date();
		return (apuesta.getFecha().getMonth() == fechaBalance.getMonth());
	}
}
