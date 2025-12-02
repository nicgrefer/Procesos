import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatosCompartidos datos = new DatosCompartidos();

        // Creamos 5 procesos
        for (int i = 1; i <= 5; i++) {
            Proceso p = new Proceso(datos, "Proceso" + i);
            p.start();
        }

        // Lectura de cadenas desde consola
        while (true) {
            System.out.print("Introduce una cadena (\"fin\" para terminar): ");
            String input = sc.nextLine();
            
            if (input.equalsIgnoreCase("fin")) {
                datos.terminar();
                break;
            }

            datos.agregarCadena(input);
        }

        sc.close();

        // Esperamos a que los procesos terminen
        datos.esperarProcesosFinalizados();

        // Mostramos todas las cadenas introducidas
        System.out.println("\nTodas las cadenas introducidas:");
        for (String s : datos.getCadenas()) {
            System.out.println(s);
        }
    }
}