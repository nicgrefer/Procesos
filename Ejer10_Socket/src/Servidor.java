import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int contadorUsuarios = 0;
		System.out.println("Servidor iniciado...");

		// Abrimos el ServerSocket fuera del bucle para no perder el puerto
		try (ServerSocket serverSocker = new ServerSocket(4444)) {
			boolean finalizar = false;

			while (!finalizar) {
				System.out.println("Esperando a un cliente...");

				// El accept() debe estar dentro del while para aceptar al siguiente cliente
				try (Socket socket = serverSocker.accept();
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

					Usuario usuario = (Usuario) ois.readObject();
					System.out.println("El usuario es: " + usuario.toString());
					contadorUsuarios += 1;

				
					if (usuario.getNombre().equalsIgnoreCase("fin")) {
						finalizar = true;
						System.out.println("Recibida orden de apagado.");
					}

				} catch (ClassNotFoundException e) {
					System.out.println("Error: Clase Usuario no encontrada.");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error en la conexión con el cliente.");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Fin del programa. Ha entrado " + contadorUsuarios + " usuarios");
	}
}