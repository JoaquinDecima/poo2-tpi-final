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

import juego.Partido;
import juego.resultado.Resultado;

public class EnCurso implements EstadoPartido {
	@Override
	public Resultado resultadoPartido(Partido partido) {
		return partido.getResultado();		
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

}
