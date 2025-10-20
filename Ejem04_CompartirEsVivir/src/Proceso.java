
public class Proceso extends Thread {

	private Contador contador;
	
	
	public Proceso(Contador contadorComun, String nombre) {
		// TODO Auto-generated constructor stub
		super(nombre);
		contador = contadorComun;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < 100; i++) {
			synchronized (contador) { // Fona de sincronización donde solo puede acceder un hilo a la vez
									 // asta que el hilo salga del bloque synchronized no puede entrar 
									// otro hilo a este bloque. 
								   // Esta zona debe ser lo mas pequeña posible para evitar cuellos 
								  //de botella.
				int temp = contador.getValor();
				temp++;
				contador.setValor(temp);
				System.out.println(this.getName()+"Valor final del contador: " + contador.getValor());
			}
			
			//sleep para simular que tarda un poco en ejecutar para forzar el cambio de contexto entre hilos
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
