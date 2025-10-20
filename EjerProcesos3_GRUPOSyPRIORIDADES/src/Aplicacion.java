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
			
			for (int i=0; i<proces;i++) {
				
			}
			
			System.out.println("2 o mas procesos :)");
		}
		

	}

}
