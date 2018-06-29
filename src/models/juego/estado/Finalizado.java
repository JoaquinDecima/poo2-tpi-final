package models.juego.estado;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.usuario.Usuario;

public class Finalizado implements EstadoPartido {

	// retorna el resultado final del partido
	@Override
	public Resultado resultadoPartido(Partido partido) {
		return partido.getResultado();
	}

	// es invocado cuando se setea el estado
	@Override
	public void accionar(Partido partido) {
		partido.notificarFinalSubscriptores();

	}

	// Retorna el estado del partido
	// Importante para Test
	public String getEstado() {
		return("Finalizado");
	}

	@Override
	public ApuestaSegura addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception {
	// si el partido ha finalizado, entonces se lanza excepcion pues ya no es posible hacer apuesta sobre el mismo.
		throw new Exception();

	}

	@Override
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception {
		throw new Exception();

	}

	@Override
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception {
		throw new Exception();
	}
}
