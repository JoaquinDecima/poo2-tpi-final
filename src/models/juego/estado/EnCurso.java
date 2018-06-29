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

public class EnCurso implements EstadoPartido {
	@Override
	public Resultado resultadoPartido(Partido partido) {
		return partido.getResultado();		
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
	
	// Retorna el estado del partido
	// Importante para Test
	public String getEstado() {
		return("En Curso");
	}

}
