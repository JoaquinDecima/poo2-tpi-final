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

import models.juego.Partido;
import models.juego.resultado.Resultado;

public interface EstadoPartido {

	Resultado resultadoPartido(Partido partido);

	// metodo llamado cuando cambia el estado
	void accionar();
		
}
