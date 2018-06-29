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

package juego.estado;

import apuesta.ApuestaSegura;
import apuesta.OpcionApuesta;
import juego.Partido;
import juego.resultado.Resultado;
import usuario.Usuario;

/*
 * Se implementa la interfaz de EstadoPartido que determina el comportamiento 
 * de la clase Partido de acuerdo al estado del mismo.
 */

public interface EstadoPartido {

	
	Resultado resultadoPartido(Partido partido);

	// metodo llamado cuando cambia el estado
	void accionar(Partido partido);

	ApuestaSegura addApuestaSegura(Usuario usuario, OpcionApuesta opcionApuesta, double monto) throws Exception;

	void reactivarApuestaSegura(ApuestaSegura apuestaAReactivar) throws Exception;

	void cancelarApuestaSegura(ApuestaSegura apuestaACancelar) throws Exception;

		
}
