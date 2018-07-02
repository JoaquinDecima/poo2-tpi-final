package models.juego.estado;

import models.juego.resultado.ResultadoNull;
import models.usuario.Usuario;
import models.apuesta.Apuesta;
import models.apuesta.ApuestaFinal;
import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
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
		// TODO Auto-generated method stub

	}


	@Override
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) {
		// TODO Auto-generated method stub

	}


	@Override
	public void addApuesta(Usuario usuario, OpcionApuesta opcionApuesta, double monto, boolean esSegura) throws Exception {
		Apuesta nuevaApuesta;
		if (esSegura) {
				nuevaApuesta = new ApuestaSegura(usuario, opcionApuesta, monto);
		} else {
				nuevaApuesta = new ApuestaFinal(usuario, opcionApuesta, monto);
		}
		opcionApuesta.getEvento().getApuestasRealizadas().add(nuevaApuesta);
	}
}
