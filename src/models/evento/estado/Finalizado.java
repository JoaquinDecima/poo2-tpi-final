package models.evento.estado;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public class Finalizado extends EstadoEvento {
	
	public Finalizado(Evento e) {
		this.evento = e;
	}
	
	@Override
	public void addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception {
		// si el partido ha finalizado, entonces se lanza excepcion		
		throw new Exception();
				
	}
	@Override
	public void accionar() {
		this.evento.pagarApuestas();
	}

	@Override
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception {
		throw new Exception();		
	}

	@Override
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception {
		throw new Exception();			
	}
	

}
