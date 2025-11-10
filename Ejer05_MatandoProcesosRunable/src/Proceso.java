
public class Proceso implements Runnable {

	private Thread hilo;
	private Contador contador;
	public Proceso(String nombre, Contador contador, ThreadGroup grupoProcesos) {
		this.contador = contador;
		hilo= new Thread(grupoProcesos,  this, nombre);
		hilo.start();
	}

	@Override
	public void run() {
		
		do {
			synchronized (contador) {
				int temp = contador.getNumero();
				temp++;
				contador.setNumero(temp);
				System.out.println("Ejecutando " + hilo.getName() + " contador:" + contador.getNumero());
			}
			
			Thread.yield(); //decir que suelte la CPU segun lo estime oportuno
			if (contador.getNumero()==3000)
			{
				int numActivo=Thread.currentThread().getThreadGroup().activeCount();
				Thread[] listaHilos= new Thread[numActivo];
				Thread.currentThread().getThreadGroup().enumerate(listaHilos);
				for (Thread hiloHermano : listaHilos) {
					if (hiloHermano != null && hiloHermano != Thread.currentThread()) {
						hiloHermano.interrupt();
					}
				}
			}
		} while (contador.getNumero() < 5000 && !Thread.currentThread().isInterrupted());
		
		

	}
}
