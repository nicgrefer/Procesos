package Principal;

import java.util.Arrays;

public class Proceso extends Thread{

	public Contador contadorComun;
	public int contadorIndividual=0;
	
	public Proceso(ThreadGroup group, String name, int prio, Contador cont) {
		super(group, name);
		this.setPriority(prio);
		this.contadorComun = cont;
	}
		
		

	@Override
	public void run() {
		super.run();

		
		while(contadorComun.getValor()<100000) {
			synchronized (contadorComun) {
				int temp = contadorComun.getValor();
				temp++;
				contadorComun.setValor(temp);
				System.out.println(this.getName() + ": " + contadorComun.getValor());
				contadorIndividual++;
			}
		}
		Thread[] hilosHermanos = new Thread[this.getThreadGroup().activeCount()];
		getThreadGroup().enumerate(hilosHermanos);
		System.out.println(Arrays.toString(hilosHermanos));
	
		System.out.println(Thread.currentThread().getName()+ " ha contado "+ contadorIndividual);
	}
}
