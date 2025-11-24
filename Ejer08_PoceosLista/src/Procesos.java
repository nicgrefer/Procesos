public class Procesos extends Thread {

    private DatoCompartido datocomp;

    public Procesos(DatoCompartido dato) {
        super();
        this.datocomp = dato;
    }

    @Override
    public void run() {
        synchronized (datocomp) {
            aumento();
            delete();
        }
    }

    private void aumento() {
        try {
            Thread.sleep(10); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int temp = datocomp.getDato();
        temp++;
        datocomp.setDato(temp);
        System.out.println("Aumento en +1 --> " + datocomp.getDato());
    }
    
    private void delete() {
        try {
            Thread.sleep(20); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int temp = datocomp.getDato();
        temp--;
        datocomp.setDato(temp);
        System.out.println("Disminuye en -1 --> " + datocomp.getDato());
    }
}