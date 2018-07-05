package models.tools;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import models.usuario.Usuario;

public class EmailTestCase {
	private EmailBalanceNotifier noti = new EmailBalanceNotifier();
	private Usuario user = mock(Usuario.class);
	
	@Test
	public void test() {
		when(user.getEmail()).thenReturn("jdecima@latinlinux.com.ar");
		noti.notiBalance(user, 3, 650.0);
	}

}
