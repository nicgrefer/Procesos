import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Procesos a crear: ");
		int proces = sc.nextInt();
		
		if (proces<2) {
			System.err.println("Como minimo tiene que ser 2 procesos");
			
		}else {
			ThreadGroup grup1 = new ThreadGroup("grup1");
			for (int i=1; i<=proces;i++) {
				
				if (i==1) {
					Procesos p1 = new Procesos(grup1, "Proceso"+i, Thread.MAX_PRIORITY);
					p1.start();
				}else {
					Procesos p2  = new Procesos(grup1, "Proceso"+i, Thread.NORM_PRIORITY);
					p2.start();
				}
				
			}
		}
	}
}
