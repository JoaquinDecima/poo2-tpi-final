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
  
  // Retorna la ganancia bruta
  public Double gananciaBruta() {
	  Double resultado = 0.0;
	  if (this.gano()) {
		  resultado = ((this.montoApostado()) * (this.opcionApostada().cuota()));  
	  }
	  
	  return resultado;
  }
  
  // Retorna True si el usuario gano la apuesta
  public boolean gano() {
	  return (this.getPartido().getResultado() == this.opcionApostada().resultado());
  }
  
  // Retorna la Ganancia Neta
  public Double ganaciaNeta() {
	  Double resultado = 0.0;
	  if (this.gano()) {
		  resultado = (this.gananciaBruta() - this.montoApostado());  
	  }
	  
	  return resultado;
  }
  public abstract Double montoApostado();
  public abstract OpcionApuesta opcionApostada();
  public abstract Evento getEvento();
  public abstract Partido getPartido();
  public abstract Usuario getUsuario();
}



