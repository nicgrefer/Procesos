
public class Aplicacion {

	public static void main(String[] args) {
		System.out.println("Hola mundo");

		// Crear y arrancar 5 hilos hijos
		Proceso[] procesos = new Proceso[5];
		for (int i = 0; i < 5; i++) {
			procesos[i] = new Proceso(i + 1);
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
