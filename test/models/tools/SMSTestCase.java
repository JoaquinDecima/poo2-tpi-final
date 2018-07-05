package models.tools;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import models.usuario.Usuario;

public class SMSTestCase {
	private SMSBalanceNotifier noti = new SMSBalanceNotifier();
	private Usuario user = mock(Usuario.class);
	
	@Test
	public void testNotiBalance() {
		noti.notiBalance(user, 3, 650.0);
	}

}
