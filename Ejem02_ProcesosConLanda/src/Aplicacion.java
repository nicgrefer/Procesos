public class Aplicacion {
    public static void main(String[] args) {
        Persona pepe = new Persona("Pepe", 18);
        System.out.println(pepe.nombre()); // ahora existe nombre()
        
//        Thread procesos = new Thread(new Runnable() { //Creo un aclase Thread y denrtro de ella creamos una clase runnable
//					
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for (int i = 0; i < 10; i++) {
//					System.out.println("Proceso " + i);
//					
//				}
//			}
//		});
//        procesos.start();
        /**Usamos Metodo Landa**/
        
        Thread procesos = new Thread (() ->{
        	
        	for (int i = 0; i<10;i++) {
        		System.out.println("Proceso " + i);
        	}
        },"Hilo hijo");
        procesos.start();
                
        System.out.println("Despues de Runneable");
       /** 
        Corredor pepito = new Corredor() {

			@Override
			public void corre() {
				// TODO Auto-generated method stub
				System.out.println("Corre Pepito");
			}
        };*/
        
        Corredor pepito = () -> System.out.println("Corre pepito");
        
        
        Bebedor maradona = (bebida) -> System.out.println("Bebo " + bebida);
        maradona.bebe("vino");
        maradona.bebe("Cocacola");
        maradona.bebe("agua (no creo)");
        
    }
}

