package ejercicio7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ContenedorPilaNumeros {

	private Deque<Integer> pilaNumeros;
	private int expectedSize;

	public ContenedorPilaNumeros() {
		super();
		this.expectedSize = 0;
	}
	
	// tiramos la excepción porque luego en el while true tenemos que hacer un try catch 
	// así cogemos la excepción de aquí y podemos hacer el break
	public synchronized Integer getNumero(int size) throws InterruptedException {
		while (pilaNumeros == null || pilaNumeros.isEmpty() || size >= this.expectedSize) {
			wait();
		}
		
		// lo tenemos que hacer null otra vez o si no no se cumplirá el while
		Integer numeroDeLaPila = pilaNumeros.pop();
		return numeroDeLaPila;
	}

	public synchronized void setPilaNumeros(Deque<Integer> pilaNumeros) {
		this.pilaNumeros = new ArrayDeque<Integer>(pilaNumeros);
		this.expectedSize++;
		notifyAll();
	}
	
}
