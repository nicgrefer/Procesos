
public class Secretaria {
	private int aprobadosDisponibles = 0;
    private int aprobadosEntregados = 0;
    private final int MAX_APROBADOS = 10;

    // Método sincronizado para que el profesor deposite aprobados
    public synchronized void depositarAprobado() {
        aprobadosDisponibles++;
        notifyAll(); // Notifica a los alumnos que esperan
    }

    // Método sincronizado para que los alumnos cojan aprobados
    public synchronized boolean cogerAprobado() {
        // Espera mientras no haya aprobados disponibles y aún queden por entregar
        while (aprobadosDisponibles == 0 && aprobadosEntregados < MAX_APROBADOS) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si hay aprobados disponibles, el alumno lo coge
        if (aprobadosDisponibles > 0) {
            aprobadosDisponibles--;
            aprobadosEntregados++;
            notifyAll();	
            return true;
        }

        // Si ya no hay más aprobados, el alumno no aprueba
        return false;
    }

    public synchronized int getAprobadosEntregados() {
        return aprobadosEntregados;
    }

    public int getMaxAprobados() {
        return MAX_APROBADOS;
    }
}