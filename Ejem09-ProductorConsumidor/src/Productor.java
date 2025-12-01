
public class Productor extends Thread {
	
	private DatoCompartido dato;
	
	
	
	public Productor(DatoCompartido datoCompartido) {
		// TODO Auto-generated constructor stub
		dato=datoCompartido;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i=0;i<10;i++)
		{
			dato.poner();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		dato.setFinalizar(true);
		synchronized (dato) {
			dato.notifyAll();
		}
		
	}
}
