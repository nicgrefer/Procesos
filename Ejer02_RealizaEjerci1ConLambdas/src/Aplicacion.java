

public class Aplicacion {

	public static void main(String[] args) {
		System.out.println("Hola mundo");

		// Crear y arrancar 5 hilos hijos
		Thread[] procesos = new Thread[5];
		for (int i = 0; i < 5; i++) {
			procesos[i] = new Thread(() ->{
					// TODO Auto-generated method stub
					for (int j = 0; j < 11; j++) {
			            System.out.println("Soy Proceso HIJO " + Thread.currentThread().getName() + ": " + j);
					}
				}
			,"Proceso-" + i);
			procesos[i].start();
		}

		// El hilo PADRE también imprime en paralelo
		for (int i = 0; i < 11; i++) {
			System.out.println("Soy Proceso PADRE: " + i);
			try {
				Thread.sleep(50); // Pausa para permitir que los hijos se mezclen
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 

	}

}
