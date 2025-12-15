public class Aplicacion {
    public static void main(String[] args) {
        final int NUM_ALUMNOS = 20;
        Secretaria secretaria = new Secretaria();

        // Crear el profesor
        Profesor profesor = new Profesor(secretaria);

        // Crear los alumnos
        Alumno[] alumnos = new Alumno[NUM_ALUMNOS];
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            alumnos[i] = new Alumno(i + 1, secretaria);
        }

        // Iniciar el profesor
        profesor.start();

        // Iniciar los alumnos
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            alumnos[i].start();
        }

        // Esperar a que todos terminen
        try {
            profesor.join();
            for (int i = 0; i < NUM_ALUMNOS; i++) {
                alumnos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Proceso finalizado ===");
        System.out.println("Aprobados entregados: " + secretaria.getAprobadosEntregados());
    }
}