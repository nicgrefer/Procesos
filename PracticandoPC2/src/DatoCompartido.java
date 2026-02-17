import java.util.ArrayList;

public class DatoCompartido {
	private ArrayList<String> ListaStrings = new ArrayList<String>();
	
	public synchronized void add(String dato) {
		ListaStrings.add(dato);
		notify();
		
	}
	public synchronized String mostrar() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListaStrings.remove(0);
	}
	
}
