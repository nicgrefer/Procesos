package Version2;

import java.util.Scanner;

public class Consumidor extends Thread{
	DatoCompartido dato;
	
	public Consumidor(DatoCompartido dato) {
		this.dato = dato;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		int numeroLeido=0;
		do {
			numeroLeido=dato.sacar();
			System.out.println("Consumidor ha leido: "+numeroLeido);
		}while(numeroLeido!=999);
	}
}
