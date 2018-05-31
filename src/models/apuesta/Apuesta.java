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

import models.juego.Partida;

public abstract class Apuesta{
  protected Partida partido;
  protected float monto;

  public Apuesta(Partida pPartido, float fMonto){
    this.partido = pPartido;
    this.monto = fMonto;
  }

  abstract float ganaciaBruta();
  abstract float ganaciaNeta();
}
