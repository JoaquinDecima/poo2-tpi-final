package models.evento.estado;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.usuario.Usuario;

public abstract class EstadoEvento {
	
	protected Evento evento;
	
	public abstract void addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception;

	public abstract void accionar();

	public abstract void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception;

	public abstract void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception;

}
