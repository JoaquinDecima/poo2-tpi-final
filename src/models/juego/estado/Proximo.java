package models.juego.estado;

import models.juego.resultado.ResultadoNull;
import models.usuario.Usuario;
import models.apuesta.Apuesta;
import models.apuesta.ApuestaFinal;
import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.juego.Partido;
import models.juego.resultado.Resultado;

public class Proximo implements EstadoPartido {

	@Override
	public Resultado resultadoPartido(Partido partido) {
		// retorna resultado objetc null patter design, pues no hay ningun resultado seteado aun
		return new ResultadoNull();
	}


	// Retorna el estado del partido
	// Importante para Test
	public String getEstado() {
		return("Proximo");
	}

	@Override
	public void accionar(Partido partido) {
		partido.notificarInicioSubscriptores();

	}


	@Override
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) {
			//se activa la apuesta
			apuestaAReactivar.updateEstado();
	}

	@Override
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) {
			apuestaACancelar.updateEstado();
			apuestaACancelar.getEvento().cobrarPenalidadApuestaCanceladaConPartidoProximo(apuestaACancelar);
	}


	@Override
	public void addApuesta(Evento evento, Usuario usuario, OpcionApuesta opcionApuesta, double monto, boolean esSegura) throws Exception {
		Apuesta nuevaApuesta;
		if (esSegura) {
				nuevaApuesta = new ApuestaSegura(evento, usuario, opcionApuesta, monto);
				evento.sumApuesta(nuevaApuesta);
				usuario.sumApuesta(nuevaApuesta);
				usuario.decrementarMontoWallet(monto);
				
		} else {
				nuevaApuesta = new ApuestaFinal(evento, usuario, opcionApuesta, monto);
				evento.sumApuesta(nuevaApuesta);
				usuario.sumApuesta(nuevaApuesta);
				usuario.decrementarMontoWallet(monto);
		}
		
	}
}
