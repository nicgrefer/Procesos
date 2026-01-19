import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Con esto reservamos el numero de puerto para nuestro poryecto (en local)
		try (ServerSocket serverSocker = new ServerSocket(4444);
				Socket socket= serverSocker.accept();
				// Flujo de datos de ENTRADA -> recojemos los datos
				InputStream is = socket.getInputStream();
				//Lo "transformamos" (embolbemos) en objetos para poder asi trabajarlo en java
				ObjectInputStream ois = new ObjectInputStream(is);
				) {
			 
			Usuario usuario = null;
			try {
				do {
					usuario=(Usuario) ois.readObject();
					System.out.println("El usuario es: "+ usuario.toString());
					
				}while (usuario.getNombre().equalsIgnoreCase("fin") == false );
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}

}
