public class Proceso extends Thread {

    private int id; // Identificador del hilo

    public Proceso(int id) {
        super(String.valueOf(id));
        //this.id = id;
        
    }

    @Override
    public void run() {
    	super.run();
        for (int i = 0; i < 11; i++) {
            System.out.println("Soy Proceso HIJO " + getName() + ": " + i);
        }
    }
}