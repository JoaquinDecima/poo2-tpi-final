package juego.estado;

import apuesta.ApuestaSegura;
import apuesta.OpcionApuesta;
import juego.Partido;
import juego.resultado.Resultado;
import juego.resultado.ResultadoNull;
import usuario.Usuario;

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
	public ApuestaSegura addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception {
		ApuestaSegura nuevaApuesta = new ApuestaSegura(usuario, opcionApuesta, monto);
		opcionApuesta.getEvento().apuestasRealizadas.add(nuevaApuesta);
		// las apuestas deberian ser guardadas en partido o evento?
		return nuevaApuesta;
		
	}

	@Override
	public void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) {
		// TODO Auto-generated method stub
		
	}
}

//devuelve resultado nll object




