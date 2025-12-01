import java.util.ArrayList;
import java.util.Arrays;

public class DatoCompartido {
	private ArrayList datos;
	private boolean finalizar=false;

	public boolean isFinalizar() {
		return finalizar;
	}

	public void setFinalizar(boolean finalizar) {
		this.finalizar = finalizar;
	}

	public ArrayList getDatos() {
		return datos;
	}

	public void setDatos(ArrayList datos) {
		this.datos = datos;
	}

	public DatoCompartido(ArrayList datos) {
		super();
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "DatoCompartido [datos=" + datos.toString()  + "]";
	}
	
	
	public synchronized int coger() {
		if (datos.size() == 0) {
			try {
				if (!finalizar)
					wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (datos.size() == 0)
			return -1;
		else 
			return (int) datos.remove(0);
	}
	
	public synchronized void poner() {
		int numero=(int)(Math.random()*10);
		datos.add(numero);
		notify();
	}
	
}
