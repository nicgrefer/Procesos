import java.util.Scanner;

public class Productor extends Thread {
	DatoCompartido dato = new DatoCompartido();

	public Productor(DatoCompartido dato) {
		// TODO Auto-generated constructor stub
		this.dato = dato;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Scanner scn = new Scanner(System.in);
		String texto = "";
		do {
			System.out.println("(Productor) Introduce un texto (fin para acabar)");
			texto = scn.nextLine();
			dato.add(texto);
			
		} while (!texto.equals("fin"));
		
	}
	
		
}
