package Version2;

public class Aplicacion {

	public static void main(String[] args) {
		DatoCompartido dato = new DatoCompartido();
		Productor productor = new Productor(dato);
		Consumidor consumidor = new Consumidor(dato);

		productor.start();
		consumidor.start();

	}

}
