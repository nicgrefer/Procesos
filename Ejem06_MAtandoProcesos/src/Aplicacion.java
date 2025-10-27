
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Proceso p1 = new Proceso("Proceso 1");
		p1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.interrupt();
		
	}

}
