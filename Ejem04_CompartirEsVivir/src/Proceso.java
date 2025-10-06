
public class Proceso extends Thread {

	private Contador contador;
	
	
	public Proceso(Contador contadorComun, String nombre) {
		// TODO Auto-generated constructor stub
		super(nombre);
		contador = contadorComun;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < 100; i++) {
			int temp = contador.getValor();
			temp++;
			contador.setValor(temp);
			System.out.println(this.getName()+"Valor final del contador: " + contador.getValor());
		}
	}
}
