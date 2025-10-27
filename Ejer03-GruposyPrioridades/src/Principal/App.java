package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public Scanner scanner;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingresa el numero de procesos a crear: ");
		int numProcesos = sc.nextInt();

		if (numProcesos <= 2) {
			System.out.println("El numero de procesos debe ser mayor o igual a 2.");
			return;
		}

		Contador contadorComun = new Contador(0);
		ThreadGroup grupoA = new ThreadGroup("Grupo A");
		ThreadGroup grupoB = new ThreadGroup("Grupo B");

		List<Proceso> procesos = new ArrayList<>();
		for (int i = 0; i < numProcesos; i++) {
			if (i==0) {
				procesos.add(new Proceso(grupoA, "Proceso " + (i + 1), Thread.MIN_PRIORITY, contadorComun));
			}else {
				procesos.add(new Proceso(grupoB, "Proceso " + (i + 1), Thread.MAX_PRIORITY, contadorComun));
			}
		}
		
		for (Proceso proceso : procesos) {
			proceso.start();
		}
	}
}
