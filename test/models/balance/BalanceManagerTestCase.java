package models.balance;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import models.apuesta.Apuesta;
import models.tools.EmailBalanceNotifier;
import models.tools.SMSBalanceNotifier;
import models.usuario.Usuario;

public class BalanceManagerTestCase {
	private BalanceManager balance = new BalanceManager();
	private Apuesta apuesta1 = mock(Apuesta.class);
	private Apuesta apuesta2 = mock(Apuesta.class);
	private Apuesta apuesta3 = mock(Apuesta.class);
	
	private Date fecha1 = new Date();
	private Date fecha2;
	
	private ArrayList<Apuesta> lista = new ArrayList<Apuesta>();
	
	private Usuario user = mock(Usuario.class);
	
	@Test
	public void testSumarNetos() {
		when(apuesta1.gananciaNeta()).thenReturn(200.00);
		when(apuesta2.gananciaNeta()).thenReturn(300.00);
		when(apuesta3.gananciaNeta()).thenReturn(500.00);
		
		lista.add(apuesta1);
		lista.add(apuesta2);
		lista.add(apuesta3);
		
		assertEquals(balance.sumaNetos(lista), 1000.00, 0.20);
	}
	
	@Test
	public void testCambioMetodo() {
		balance.enviarEmail();
		assertTrue(balance.getMetodoEnvio() instanceof EmailBalanceNotifier);
		balance.enviarSMS();
		assertTrue(balance.getMetodoEnvio() instanceof SMSBalanceNotifier);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testEsDeEsteMes() {
		Calendar calendario = Calendar.getInstance();
		
		calendario.setTime(fecha1);
		calendario.add(calendario.MONTH, -2);
		fecha2 = calendario.getTime();
		when(apuesta1.getFecha()).thenReturn(fecha1);
		when(apuesta2.getFecha()).thenReturn(fecha2);
		
		assertTrue(balance.esDeEsteMes(apuesta1));
		assertFalse(balance.esDeEsteMes(apuesta2));
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testBalance() {
		Calendar calendario = Calendar.getInstance();
		
		calendario.setTime(fecha1);
		calendario.add(calendario.MONTH, -2);
		
		fecha2 = calendario.getTime();
		
		when(apuesta1.getFecha()).thenReturn(fecha1);
		when(apuesta2.getFecha()).thenReturn(fecha2);
		when(apuesta3.getFecha()).thenReturn(fecha1);
		
		when(apuesta1.gananciaNeta()).thenReturn(200.00);
		when(apuesta2.gananciaNeta()).thenReturn(300.00);
		when(apuesta3.gananciaNeta()).thenReturn(500.00);
		
		lista.add(apuesta1);
		lista.add(apuesta2);
		lista.add(apuesta3);
		
		balance.enviarBalance(user, lista);
		
	}
}
