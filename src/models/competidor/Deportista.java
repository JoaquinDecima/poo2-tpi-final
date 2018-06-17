package competidor;

//Importa Utilidades Java
import java.util.Date;


public class Deportista implements Competidor {
	protected String nombre;
	protected String lugarNat;
	protected Date fechaNat;
	
	public Deportista(String sNombre, String sLugar, Date dFecha) {
		this.nombre = sNombre;
		this.lugarNat = sLugar;
		this.fechaNat = dFecha;
	}
	
	// Retorna el nombre del Deportista
	public String getNombre() {
		return(this.nombre);
	}
	
	// Retorna el Lugar de nacimiento del Jugador
	public String getLugarNatal(){
		return(this.lugarNat);
	}
}
