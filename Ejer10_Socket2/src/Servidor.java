import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	private static List<ManejadorCliente> clientes = new ArrayList<>();

	public static void main(String[] args) {
		int contadorUsuarios = 0;
		System.out.println("Servidor iniciado...");

		try (ServerSocket serverSocket = new ServerSocket(5555)) {
			boolean finalizar = false;

			while (!finalizar) {
				System.out.println("Esperando a un cliente...");
				Socket socket = serverSocket.accept();
				
				try {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					
					Usuario usuario = (Usuario) ois.readObject();
					System.out.println("El usuario " + usuario.getNombre() + " se ha conectado.");
					contadorUsuarios++;

					if (usuario.getNombre().equalsIgnoreCase("fin")) {
						finalizar = true;
						System.out.println("Recibida orden de apagado.");
						ois.close();
						oos.close();
						socket.close();
					} else {
						ManejadorCliente manejador = new ManejadorCliente(socket, usuario, ois, oos);
						clientes.add(manejador);
						new Thread(manejador).start();
					}

				} catch (ClassNotFoundException e) {
					System.out.println("Error: Clase Usuario no encontrada.");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Fin del programa. Ha entrado " + contadorUsuarios + " usuarios");
	}
	
	public static void difundirMensaje(String mensaje, Usuario remitente) {
		for (ManejadorCliente cliente : clientes) {
			if (!cliente.getUsuario().getNombre().equals(remitente.getNombre())) {
				cliente.enviarMensaje(mensaje);
			}
		}
	}
	
	public static void removerCliente(ManejadorCliente cliente) {
		clientes.remove(cliente);
		System.out.println("El usuario " + cliente.getUsuario().getNombre() + " se ha desconectado.");
	}
}