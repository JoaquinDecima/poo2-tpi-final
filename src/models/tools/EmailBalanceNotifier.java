package models.tools;

import models.usuario.Usuario;

public class EmailBalanceNotifier implements Notifier {
	
	public void emailBalance(String user, int month, Double monthlyBalance){
	}

	@Override
	public void notiBalance(Usuario user, int month, Double dNetos) {
		this.emailBalance(user.getEmail(), month, dNetos);
	}
}
