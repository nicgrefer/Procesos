
public class DatoCompartido {

	private String dato;

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public synchronized void poner() {
		// TODO Auto-generated method stub
		this.notify();
	}

	public synchronized String coger() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}
	
	
	
}
