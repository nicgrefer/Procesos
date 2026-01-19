import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Socket socket = new Socket("localhost", 4444);
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				Scanner scn = new Scanner(System.in)) {

			String mensaje = null;

			System.out.println("Que nombre se usuario envias: (fin para terminar)");
			mensaje = scn.nextLine();
			Usuario us = new Usuario(mensaje, 25);
			oos.writeObject(us);// el writeObject tecibe un objeto ✅

		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
