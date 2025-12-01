
public class Proceso extends Thread {

	
	private DatosCompartidos datos;
	
	public Proceso(DatosCompartidos datos, String nombre) {
		super(nombre);
		this.datos = datos;
	}
	
	@Override
	public void run() {
		synchronized (datos) {
			try {
				System.out.println("Proceso esperando...");
				datos.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Proceso reanudado.");
			String[] cadena = datos.getCadena();
			for (String s : cadena) {
				System.out.println(s);
			}
		}
	}
}
