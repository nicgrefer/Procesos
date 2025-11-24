import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {
        DatoCompartido dato = new DatoCompartido();
        
        while (dato.getDato() <= 10) {
            Procesos p = new Procesos(dato);
            p.start();
            
           
        }
        
        System.out.println("\n=== Programa terminado ===");
        System.out.println("Valor final: " + dato.getDato());
    }
}