import java.util.ArrayList;
import java.util.List;

class DatosCompartidos {

    private final List<String> cadenas = new ArrayList<>();
    private boolean terminado = false;

    // Hilos activos para esperar al final
    private final List<Thread> procesos = new ArrayList<>();

    public synchronized void agregarCadena(String cadena) {
        cadenas.add(cadena);
        notifyAll(); 
    }

    public synchronized String recuperarCadena() {
        while (cadenas.isEmpty() && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (cadenas.isEmpty() && terminado) {
            return null; // señal de terminación
        }

        // Recuperamos la última cadena añadida
        return cadenas.remove(cadenas.size() - 1);
    }

    public synchronized List<String> getCadenas() {
        return new ArrayList<>(cadenas);
    }

    public synchronized void terminar() {
        terminado = true;
        notifyAll(); // despertamos a todos los procesos para que puedan terminar
    }

    public void registrarProceso(Thread t) {
        procesos.add(t);
    }

    public void esperarProcesosFinalizados() {
        for (Thread t : procesos) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}