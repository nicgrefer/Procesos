package Version1;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		
		ArrayList<Integer> compartido = new ArrayList<>();
		
		Thread productor=new Thread(() -> {
			try (Scanner sc = new Scanner(System.in);) {
				int numeroLeido=0;
				do {
					numeroLeido=sc.nextInt();
					compartido.add(numeroLeido);
					synchronized (compartido) {
						compartido.notify();
					}
				}while(numeroLeido!=999);
			}catch (Exception e) {		}
		});
		productor.start();
		Thread consumidor=new Thread(() -> {
			synchronized (compartido) {
				int numeroLeido=0;
				do {
					try {
						compartido.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					numeroLeido=compartido.remove(0);
					System.out.println("Consumidor ha leido: "+numeroLeido);
				}while(numeroLeido!=999);
				System.out.println("Se finalizo el programa");
			}
		});
		consumidor.start();
	}
}

