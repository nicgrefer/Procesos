package Version2;

import java.util.Scanner;

public class Productor extends Thread {
	private DatoCompartido dato;

	public Productor(DatoCompartido dato) {
		this.dato = dato;
	}

	@Override
	public void run() {
		try (Scanner sc = new Scanner(System.in);) {
			int numeroLeido=0;
			do {
				numeroLeido=sc.nextInt();
				dato.poner(numeroLeido);
			}while(numeroLeido!=999);
		} catch (Exception e) {

		}
	}

}
