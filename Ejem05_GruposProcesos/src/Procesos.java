import java.util.Arrays;

public class Procesos extends Thread {

	public Procesos(ThreadGroup group, String name, int priority) {
		super(group, name);
		this.setPriority(priority);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(getThreadGroup().getName() + " - " +getName() + " - " + i);
		}
		Thread[] hilosHermanos = new Thread[this.getThreadGroup().activeCount()]; // obtiene el numero de hilos .
																		 //activos en el grupo
		
		getThreadGroup().enumerate(hilosHermanos);// llena el array con los hilos activos del grupo
		
		System.out.println(Arrays.toString(hilosHermanos)); // imprime los hilos activos del grupo
		
	}
	
	

	
	
}
