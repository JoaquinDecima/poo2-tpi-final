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

import java.util.Date;

import models.apuesta.opcion.OpcionApuesta;
import models.evento.Evento;
import models.juego.Partido;
import models.usuario.Usuario;

public abstract class Apuesta{
  protected Evento evento;
  protected OpcionApuesta apuesta;
  protected Double monto;
  protected Double ganaciaNeta;
  protected Double ganaciaBruta;
  protected Usuario usuario;

  // Retorna la ganancia bruta
  public Double intGananciaBruta() {
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
  public Double intGanaciaNeta() {
	  Double resultado = 0.0;
	  if (this.gano()) {
		  resultado = (this.gananciaBruta() - this.montoApostado());
	  }

	  return resultado;
  }
  
  public Double gananciaBruta() {
	  return (this.ganaciaBruta);
  }
  
  public Double gananciaNeta() {
	  return (this.ganaciaNeta);
  }

  // Retorna el Monto apostado
  public Double montoApostado() {
	  return (this.monto);
  }

  // Retorna la opcion Apostada
  public OpcionApuesta opcionApostada() {
	  return (this.apuesta);
  }

  // Retorna el Evento
  public Evento getEvento() {
	  return(this.evento);
  }

  // Retorna el Partido
  public Partido getPartido() {
	  return (this.evento.getPartidoDelEvento());
  }

  // Retorna el Usuario
  public Usuario getUsuario() {
	  return (this.usuario);
  }

  // Retorna la Fecha del Evento
  public Date getFecha() {
	  return(this.evento.getFecha());
  }

  public void calcularGanancias() {
	this.ganaciaBruta = this.intGananciaBruta();
	this.ganaciaNeta = this.intGanaciaNeta();
  }
}
