import java.util.ArrayList;
import java.util.List;

class Proceso extends Thread {

    private DatosCompartidos datos;
    private List<String> misCadenas; // Lista de cadenas recuperadas por este hilo

    public Proceso(DatosCompartidos datos, String nombre) {
        super(nombre);
        this.datos = datos;
        this.misCadenas = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            String cadena = datos.recuperarCadena();
            if (cadena == null) {
                // Señal de finalización
                break;
            }
            misCadenas.add(cadena); // Guardamos la cadena que recuperamos
            System.out.println(getName() + " recuperó: " + cadena);
        }
        // Al finalizar, mostramos todas las cadenas recuperadas por este hilo
        System.out.println(getName() + " ha recogido: " + misCadenas);
    }
}
 