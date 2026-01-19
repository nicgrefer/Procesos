import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

	private static List<ManejadorCliente> clientesConectados = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Servidor iniciado...");

		try (ServerSocket serverSocket = new ServerSocket(4444)) {
			boolean finalizar = false;
			int contadorUsuarios = 0;

			while (!finalizar) {
				System.out.println("Esperando conexión de nuevo cliente...");

				try {
					Socket socket = serverSocket.accept();
					contadorUsuarios++;
					System.out.println("Cliente conectado. Total: " + contadorUsuarios);

					ManejadorCliente manejador = new ManejadorCliente(socket);
					clientesConectados.add(manejador);
					manejador.start();

				} catch (IOException e) {
					System.out.println("Error al aceptar conexión: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("Error al iniciar el servidor: " + e.getMessage());
		}

		System.out.println("Servidor finalizado.");
	}
}