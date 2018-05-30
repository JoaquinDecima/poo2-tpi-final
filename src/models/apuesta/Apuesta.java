package models.apuesta;

import models.juego.Patrida.*;

public class Apuesta{
  protected Partida partido;
  protected float monto;

  public Apuesta(Partida pPartido, float fMonto){
    this.partido = pPartido;
    this.monto = fMonto;
  }

  abstract float ganaciaBruta();
  abstract float ganaciaNeta();
}
