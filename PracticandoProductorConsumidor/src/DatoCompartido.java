import java.util.ArrayList;

public class DatoCompartido {

	private ArrayList<Integer> compartido = new ArrayList<Integer>();
	
	public synchronized void poner(int numero) {
		compartido.add(numero);
		notifyAll();
	}
	
	public synchronized int sacar() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compartido.remove(0);
	}
}
