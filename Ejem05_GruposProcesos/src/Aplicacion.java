
public class Aplicacion {
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		
		ThreadGroup grupoA = new ThreadGroup("Grupo A");
		ThreadGroup grupoB = new ThreadGroup("Grupo B");
		
		Procesos p1 = new Procesos(grupoA, "Proceso 1",Thread.MAX_PRIORITY);
		Procesos p2 = new Procesos(grupoA, "Proceso 2",Thread.MAX_PRIORITY);
		Procesos p3 = new Procesos(grupoA, "Proceso 3",Thread.MAX_PRIORITY);
		Procesos p4 = new Procesos(grupoB, "Proceso 4",Thread.MIN_PRIORITY);
		Procesos p5 = new Procesos(grupoB, "Proceso 5",Thread.MIN_PRIORITY);
		Procesos p6 = new Procesos(grupoB, "Proceso 6",Thread.MIN_PRIORITY);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		
		
	}
}
