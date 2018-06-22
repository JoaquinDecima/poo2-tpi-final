package evento;

import apuesta.ApuestaSegura;
import apuesta.OpcionApuesta;
import usuario.Usuario;

public abstract class EstadoEvento {
	
	protected Evento evento;
	
	public abstract void addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception;

	public abstract void accionar();

	public abstract void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception;

	public abstract void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception;

}
