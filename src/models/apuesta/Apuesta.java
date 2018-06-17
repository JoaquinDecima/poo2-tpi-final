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

package apuesta;

import evento.Evento;
import usuario.Usuario;

public abstract class Apuesta{
  protected Evento evento;
  protected OpcionApuesta apuesta;
  protected Double monto;
  protected Usuario usuario;
  

  abstract float ganaciaBruta();
  abstract float ganaciaNeta();
  abstract Double montoApostado();
  abstract OpcionApuesta opcionApostada();
}



