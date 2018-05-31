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

public class Deporte{
	protected String nombreDeporte;
  protected Boolean permiteEmpate;

  public Deporte(String sNombre, Boolean bPermiteEmpate){
    this.nombreDeporte = sNombre;
    this.permiteEmpate = bPermiteEmpate;
  }

	// Retrona el nombre del Deporte
  public String getNombre(){
    return(this.nombreDeporte);
  }

	// Retrona True si el deporte permite empate
  public Boolean permiteEmpate(){
    return(this.permiteEmpate);
  }

	// Retorna True si "dDeporte" es el mismo deporte que this
	public Boolean esDeporte(Deporte dDeporte){
    return(this.getNombre() == dDeporte.getNombre());
  }
}
