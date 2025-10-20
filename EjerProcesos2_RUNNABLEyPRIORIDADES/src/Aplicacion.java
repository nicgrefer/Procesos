
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Contador contadorComun = new Contador(0);
		Procesos p1 = new Procesos(contadorComun, "p1",Thread.MAX_PRIORITY);
		Procesos p2 = new Procesos(contadorComun, "p2",Thread.NORM_PRIORITY);
		Procesos p3 = new Procesos(contadorComun, "p3",Thread.MIN_PRIORITY);
		
		p1.run();
		p2.run();
		p3.run();
		
	}

}
