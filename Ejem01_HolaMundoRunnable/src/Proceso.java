
public class Proceso implements Runnable {

	private Thread proceso;

	public Proceso() {
		super();
		// TODO Auto-generated constructor stub
		proceso = new Thread(this); // creamos un runnable task
		proceso.start();// así podemos hacer el start()
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run(); ahora puedo quirarlo porque run esta dentro de la clase run y
		// por lo tanto no es necesario implemenrtar

		for (int i = 0; i < 11; i++) {
			System.out.println("Soy Proceso HIJO: " + i);

		}

	}

}
