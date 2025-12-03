import java.util.Random;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i<=3;i++) {
			
			System.out.println("-----Vuelta "+i+"----");
			
			for (int j = 1; j<=5;j++){
				Random r = new Random();
				int num = r.nextInt(5)+1;
				System.out.println(j+" numero aleatorio "+num);
			}	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
