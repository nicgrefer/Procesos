
public class Consumidor extends Thread {

	private DatoCompartido dato;
	
	public Consumidor(DatoCompartido datoCompartido, String nombre) {
		super(nombre);
		dato=datoCompartido;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i=0;i<10 && !dato.isFinalizar();i++)
		{
			System.out.println(Thread.currentThread().getName()+" - "+ dato.coger()+ " - "+dato.toString());
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
