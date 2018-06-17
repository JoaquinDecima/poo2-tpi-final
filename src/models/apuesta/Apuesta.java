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

package models.apuesta;

import models.evento.*;

public abstract class Apuesta{
  protected Evento evento;
  protected OpcionApuesta apuesta;
  protected float monto;
  

  abstract float ganaciaBruta();
  abstract float ganaciaNeta();
  abstract float montoApostado();
  abstract OpcionApuesta opcionApostada();
}



