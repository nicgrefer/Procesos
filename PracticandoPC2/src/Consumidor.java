
public class Consumidor extends Thread {
	private DatoCompartido dato = new DatoCompartido();

	public Consumidor(DatoCompartido dato) {
		// TODO Auto-generated constructor stub
		this.dato = dato;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String texto = "";
		do {
			texto = dato.mostrar();
			System.out.println("(Consumidor): "+texto);
		} while (!texto.equals("fin"));
	}
	

}
