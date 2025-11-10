
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador contador = new Contador(0);
		ThreadGroup grupoProcesos = new ThreadGroup("Grupo de Procesos");
		Proceso p1 = new Proceso("Proceso 1",contador,grupoProcesos);
		Proceso p2 = new Proceso("Proceso 2",contador,grupoProcesos);
		Proceso p3 = new Proceso("Proceso 3",contador,grupoProcesos);
		Proceso p4 = new Proceso("Proceso 4",contador,grupoProcesos);
		Proceso p5 = new Proceso("Proceso 5",contador,grupoProcesos);


	
		System.out.println("Muerte a los demas hermanos");

	}

}
