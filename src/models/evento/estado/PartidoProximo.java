package evento.estado;

import apuesta.ApuestaSegura;
import apuesta.opcion.OpcionApuesta;
import evento.Evento;
import usuario.Usuario;

public class PartidoProximo extends EstadoEvento {

	public PartidoProximo(Evento e) {
		this.evento = e;
	}
	
	@Override
	public void addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) {
		// si no finalizo el partido, entonces se crea la apuesta solicitada por el usuario
		ApuestaSegura nuevaApuesta = new ApuestaSegura(usuario, this.evento, opcionApuesta, monto);
		this.evento.apuestasRealizadas.add(nuevaApuesta);

	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception {
		// se cobra penalidad por cancelacion
		this.evento.cobrarPenalidadApuestaCancelada(apuestaACancelar);
		// cambia estado de la apuesta. Ahora ya no esta activa.
		apuestaACancelar.updateEstado();			
	}

	@Override
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception {
		apuestaAReactivar.updateEstado();	
	}

}
