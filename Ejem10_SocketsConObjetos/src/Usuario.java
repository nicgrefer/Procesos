import java.io.Serializable;

// Necesitamos meter el serializable para que no
//casque ya que ebita la confusion entre distintos objetos
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	
	
	public Usuario(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
	
	
}
