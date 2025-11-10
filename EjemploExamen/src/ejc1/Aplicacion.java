package ejc1;

public class Aplicacion {


	
	public static void main(String[] args) {
		ThreadGroup grupoVIP = new ThreadGroup("Grupo Vip");
		ThreadGroup grupoB = new ThreadGroup("Grupo B");
		
		Contador contadorComun=new Contador(0);
		Ventanilla v1= new Ventanilla(grupoVIP, "ventanilla1",Thread.MAX_PRIORITY, contadorComun);
		Ventanilla v2= new Ventanilla(grupoVIP, "ventanilla2",Thread.MAX_PRIORITY ,contadorComun);
		Ventanilla v3= new Ventanilla(grupoB, "ventanilla3", Thread.MIN_PRIORITY,contadorComun);
		Ventanilla v4= new Ventanilla(grupoB, "ventanilla4", Thread.MIN_PRIORITY,contadorComun);
		v1.start();
		v2.start();
		v3.start();
		v4.start();
	
		
		try {
			v1.join();
			v2.join();
			v3.join();
			v4.join();
		} catch (Exception e) {
			
		}
		System.out.println("NO HAY MAS ENTRADAS");

	}
	
	

}
