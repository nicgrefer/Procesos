package ejc1;

public class Ventanilla extends Thread {

	public Contador contadorComun;
	public int contadorIndividual;

	public Ventanilla(ThreadGroup group, String name, int prio, Contador contadorComun) {
		super(group, name);
		this.setPriority(prio);
		this.contadorComun = contadorComun;

	}

	@Override
	public void run() {
		super.run();

		do {
			synchronized (contadorComun) {
				if (contadorComun.getNumero() < 50000) {
					int temp = contadorComun.getNumero();
					temp++;
					contadorComun.setNumero(temp);
					System.out.println(this.getName() + ": " + contadorComun.getNumero());
					contadorIndividual++;
				}
			}
			
		} while (contadorComun.getNumero() < 50000);

		System.out.println(this.getName() + " ha contado: " + contadorIndividual + " veces");

	}

}
