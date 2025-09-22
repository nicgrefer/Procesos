
public class Proceso extends Thread {

	public Proceso() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 11; i++) {
			System.out.println("Soy Proceso HIJO: " + i);

		}

	}

}
