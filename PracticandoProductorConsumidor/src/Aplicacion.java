
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stubç
		
		DatoCompartido dato = new DatoCompartido();
		Productor p = new Productor(dato);
		Consumidor c = new Consumidor(dato);
		
		p.start(); c.start();

	}

}
