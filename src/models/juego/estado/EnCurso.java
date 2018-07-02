/*
 * Programacion Orientada a Objetos II 2018 s1
 * Universidad Nacional de Quilmes
 *
 * Casa de Apuestas HITO 1
 *
 * Alumnos:
 *        Decima, Joaquin A. (Pato)
 *        Otarola, Florencia
 */

package models.juego.estado;

import models.apuesta.ApuestaSegura;
import models.apuesta.opcion.OpcionApuesta;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.usuario.Usuario;

public class EnCurso implements EstadoPartido {
	@Override
	public Resultado resultadoPartido(Partido partido) {
		return partido.getResultado();
	}


	// Retorna el estado del partido
	// Importante para Test
	public String getEstado() {
		return("En Curso");
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
		apuestaACancelar.updateEstado();
		apuestaACancelar.getEvento().cobrarPenalidadApuestaCanceladaConPartidoEnCurso(apuestaACancelar);
	}


	@Override
	public void addApuesta(Usuario usuario, OpcionApuesta opcionApuesta, double monto, boolean esSegura)
			throws Exception {
		throw new Exception();		
	}






}
