
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer contadorComun = Integer.valueOf(0);
		Proceso p1 = new Proceso(contadorComun);
		Proceso p2 = new Proceso(contadorComun);
		Proceso p3 = new Proceso(contadorComun);
		
		p1.start();
		p2.start();
		p3.start();
		
		
	}

}
