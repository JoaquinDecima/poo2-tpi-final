package models.tools;

import models.usuario.Usuario;

public class SMSBalanceNotifier implements Notifier{
	
	void notifyBalance(Usuario user, Integer month, Double monthlyBalance){

	   }

	@Override
	public void notiBalance(Usuario user, int month, Double dNetos) {
		this.notifyBalance(user, month, dNetos);
	}
}
