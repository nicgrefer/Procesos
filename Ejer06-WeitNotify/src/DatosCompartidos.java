
public class DatosCompartidos {

	private String [] cadena;

	public DatosCompartidos() {
		super();
		this.cadena = new String[0];
	}
	
	public synchronized String[] getCadena() {
		return cadena;
	}
	
	public synchronized void setCadena(String[] cadena) {
		this.cadena = cadena;
	}
	
	
	
}
