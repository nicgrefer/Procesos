
public class Procesos extends Thread {

	private DatoCompartido dato;

	public Procesos(DatoCompartido dato) {
		super();
		this.dato = dato;
	}

	@Override
	public void run() {
		super.run();
		String valor =  dato.coger();
		
		System.out.println("Soy el proceso auxiliar "+ valor);
		
	}

	
	
}
