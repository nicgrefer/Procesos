import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		try (Socket socket = new Socket("localhost", 5555);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

			System.out.println("Introduce tu nombre de usuario:");
			String nombre = scn.nextLine();
			Usuario usuario = new Usuario(nombre, 25);
			oos.writeObject(usuario);
			oos.flush();

			Thread receptorThread = new Thread(() -> {
				try {
					while (true) {
						String mensajeRecibido = (String) ois.readObject();
						System.out.println(mensajeRecibido);
					}
				} catch (ClassNotFoundException | IOException e) {
					System.out.println("Conexión cerrada.");
				}
			});
			receptorThread.start();

			System.out.println("Chat iniciado. Escribe tus mensajes (escribe 'fin' para salir):");
			
			while (true) {
				String mensaje = scn.nextLine();
				oos.writeObject(mensaje);
				oos.flush();
				
				if (mensaje.equalsIgnoreCase("fin")) {
					break;
				}
			}

			receptorThread.interrupt();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scn.close();
		}
	}
}
