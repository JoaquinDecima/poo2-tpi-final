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

package models.deporte;

// Importa Modelos
import models.deporte.Deporte.*;

public class Basquetball extends Deporte{

  public Basquetball(){
    this.nombreDeporte = "Basquetball";
    this.permiteEmpate = True;
  }
}
