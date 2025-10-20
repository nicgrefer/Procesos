
public class Procesos extends Thread {
	
	private Contador cont;

	public Procesos(Contador contador, String nombre, int Priority) {
		// TODO Auto-generated constructor stub
		super(nombre);
		this.setPriority(Priority);
		cont = contador;
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 1; i <= 100; i++) {
					synchronized (cont) { 
							int temp = cont.getValor();
							temp++;
							cont.setValor(temp);
							System.out.println(this.getName()+"Valor final del contador: " + cont.getValor());
						}
		}
	}
}
