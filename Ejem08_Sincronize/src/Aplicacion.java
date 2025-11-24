import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatoCompartido dato = new DatoCompartido();
		
		Procesos p=new Procesos(dato);
		p.start();
		

		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce tu nombre:");
		String nombre=teclado.nextLine();
		dato.setDato(nombre);
		
		synchronized (dato) {
			dato.notify();	
		}
		
		
	}

}
