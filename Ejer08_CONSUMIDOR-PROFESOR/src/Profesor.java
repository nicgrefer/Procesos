class Profesor extends Thread {
    Secretaria secretaria;

    public Profesor(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    @Override
    public void run() {
        for (int i = 0; i < secretaria.getMaxAprobados(); i++) {
            try {
                Thread.sleep(2000); // Cada 20 milisegundos
                secretaria.depositarAprobado();
                System.out.println("Profesor deposita aprobado #" + (i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}