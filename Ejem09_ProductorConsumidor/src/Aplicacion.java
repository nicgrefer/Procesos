import java.util.ArrayList;
import java.util.Arrays;

public class Aplicacion {
    /**
     * Esta versión no mostrará los valores -1 de los consumidores
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DatoCompartido datoCompartido = new DatoCompartido(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
		DatoCompartido datoCompartido = new DatoCompartido(new ArrayList<>());
		Consumidor consumidor = new Consumidor(datoCompartido,"Consumidor1");
		Productor productor = new Productor(datoCompartido);
		productor.start();
		consumidor.start();
		Consumidor consumidor2 = new Consumidor(datoCompartido,"Consumidor1");
		consumidor2.start();
	}

}
