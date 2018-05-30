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
}
