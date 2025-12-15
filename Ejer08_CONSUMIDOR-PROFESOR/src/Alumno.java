class Alumno extends Thread {
    int numAlumno;
    Secretaria secretaria;

    public Alumno(int numAlumno, Secretaria secretaria) {
        super();
        this.numAlumno = numAlumno;
        this.secretaria = secretaria;
    }

    public int getNumAlumno() {
        return numAlumno;
    }

    public void setNumAlumno(int numAlumno) {
        this.numAlumno = numAlumno;
    }

    @Override
    public String toString() {
        return "Soy el alumno " + numAlumno + " y ";
    }

    @Override
    public void run() {
        boolean aprobado = secretaria.cogerAprobado();
        if (aprobado) {
            System.out.println(this.toString() + "he aprobado");
        } else {
            System.out.println(this.toString() + "no he aprobado");
        }
    }
}