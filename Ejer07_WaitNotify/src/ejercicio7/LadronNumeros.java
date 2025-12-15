package ejercicio7;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class LadronNumeros extends Thread {

	private List<Integer> listaRobados = new ArrayList<Integer>();

	private ContenedorPilaNumeros cpn;

	public LadronNumeros(String nombre, ContenedorPilaNumeros cpn) {
		super(nombre);

		this.cpn = cpn;
	}
	
	

	public List<Integer> getListaRobados() {
		return listaRobados;
	}

	@Override
	public void run() {
		while (true) {

			try {
				int numeroRobado = cpn.getNumero(listaRobados.size());

				listaRobados.add(numeroRobado);
				
				// cojo la excepción y paro
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
