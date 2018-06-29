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
import juego.Partido;
import usuario.Usuario;

public abstract class Apuesta{
  protected Evento evento;
  protected OpcionApuesta apuesta;
  protected Double monto;
  protected Usuario usuario;
  protected Double gananciaBruta;
  protected Double gananciaNeta;
  

  public abstract Double ganaciaBruta();
  public abstract Double ganaciaNeta();
  public abstract void setGananciaBruta(Double monto);
  public abstract void setGananciaNeta(Double monto);
  public abstract Double montoApostado();
  public abstract OpcionApuesta opcionApostada();
  public abstract Evento getEvento();
  public abstract Partido getPartido();
  public abstract Usuario getUsuario();
  public void calcularGanancias() {
	  this.setGananciaBruta(this.montoApostado() * this.opcionApostada().cuota());
		this.setGananciaNeta(gananciaBruta - this.montoApostado());
  };
}



