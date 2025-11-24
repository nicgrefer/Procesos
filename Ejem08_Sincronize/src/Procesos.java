
public class Procesos extends Thread {

	private DatoCompartido datocomp;

	public Procesos(DatoCompartido dato) {
		super();
		this.datocomp = dato;
	}

	@Override
	public void run() {
		super.run();
		synchronized (datocomp) {
			try {
				datocomp.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Soy el proceso auxiliar "+ datocomp.getDato());
		
	}

	
	
}
