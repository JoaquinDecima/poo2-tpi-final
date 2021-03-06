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
import models.evento.Evento;
import models.juego.Partido;
import models.juego.resultado.Resultado;
import models.usuario.Usuario;

public interface EstadoPartido {


	Resultado resultadoPartido(Partido partido);

	// metodo llamado cuando cambia el estado
	void accionar(Partido partido);

	void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception;

	void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception;

	void addApuesta(Evento evento, Usuario usuario, OpcionApuesta opcionApuesta, double monto, boolean esSegura) throws Exception;


}
