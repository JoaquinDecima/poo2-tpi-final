package models.tools;

import models.usuario.Usuario;

public interface Notifier {

	void notiBalance(Usuario user, int month, Double dNetos);

	

}
