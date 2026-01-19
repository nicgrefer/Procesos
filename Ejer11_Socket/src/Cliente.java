import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 4444);
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				Scanner scn = new Scanner(System.in)) {

			System.out.println("Conectado al servidor. Puedes enviar mensajes.");
			System.out.println("Escribe 'fin' para terminar la conexión.");

			while (true) {
				System.out.print("Mensaje a enviar: ");
				String mensaje = scn.nextLine();
				
				if (mensaje.equalsIgnoreCase("fin")) {
					Usuario us = new Usuario(mensaje, 0);
					oos.writeObject(us);
					break;
				}

				Usuario us = new Usuario(mensaje, 25);
				oos.writeObject(us);
				oos.flush();
			}

		} catch (UnknownHostException e) {
			System.out.println("Host no encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de conexión: " + e.getMessage());
		}

		System.out.println("Cliente finalizado.");
	}
}
