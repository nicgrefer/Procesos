
public class Consumidor extends Thread {

	private DatoCompartido dato;
	public Consumidor(DatoCompartido dato) {
		this.dato = dato;
	}
	
	@Override
	public void run() {
		int numRecibido = 0;		
		do {
			numRecibido = dato.sacar();		
			System.out.println("(Consumidor) El numero es :"+numRecibido);
		} while (numRecibido!=999);
	}

}
