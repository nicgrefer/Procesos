import java.util.Scanner;

public class Productor extends Thread {

	private DatoCompartido dato;
	public Productor(DatoCompartido dato) {
		this.dato = dato;
	}
	
	@Override
	public void run() {
		try (Scanner scn = new Scanner(System.in)) {
			System.out.println("(Productor) Introduce un numero entero");
			int numeroLeido=scn.nextInt();
			do {
				dato.poner(numeroLeido);
			} while (numeroLeido != 999);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
