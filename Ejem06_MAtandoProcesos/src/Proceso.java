 
public class Proceso extends Thread {
	public Proceso (String nombre) {
		super(nombre);
	}
	

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i<1000 && !Thread.currentThread().isInterrupted(); i++) {
			System.out.println("Proceso " + getName() + " - Inrtegracion: " + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			
		}
		
	}
	
}
