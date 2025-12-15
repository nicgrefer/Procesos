package ejercicio7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.random.RandomGenerator;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		ContenedorPilaNumeros contenedor = new ContenedorPilaNumeros();
		List<LadronNumeros> listaLadrones = new ArrayList<LadronNumeros>();
		for (int i = 1; i <= 5; i++) {
			LadronNumeros ladron = new LadronNumeros("Ladrón "+i, contenedor);
			ladron.start();
			listaLadrones.add(ladron);
		}
		
		RandomGenerator r = RandomGenerator.getDefault();
		List<Deque<Integer>> listaNumerosAleatorios = new ArrayList<Deque<Integer>>(3); // histórico
		
		int contador = 0;
		do {
			Deque<Integer> pilaNumerosAleatorios = new ArrayDeque<Integer>();
			
			for (int i = 0; i < 5; i++) {
				int num = r.nextInt(100)+1;
				
				pilaNumerosAleatorios.push(num);
			} 
			
			contenedor.setPilaNumeros(pilaNumerosAleatorios);
			listaNumerosAleatorios.add(pilaNumerosAleatorios);
			Thread.sleep(3000);
			
			contador++;
		} while (contador <3);
		
		for (LadronNumeros ladron : listaLadrones) {
			ladron.interrupt();
		}
		
		for (LadronNumeros ladron : listaLadrones) {
			ladron.join();
		}
		
		System.out.println("RESULTADOS");
		System.out.println(listaNumerosAleatorios);
		
		for (LadronNumeros ladron : listaLadrones) {
			System.out.println("El "+ ladron.getName()+" ha robado los siguientes números: "+ladron.getListaRobados());
		}
	}

}
