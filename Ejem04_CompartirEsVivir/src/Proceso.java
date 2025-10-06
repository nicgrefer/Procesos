
public class Proceso extends Thread {

	private Integer contador;
	
	public Proceso(Integer contadorComun) {
		// TODO Auto-generated constructor stub
		contador = contadorComun;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < 100; i++) {
			contador++;
			System.out.println("Valor final del contador: " + contador);
		}
	}
}
