package com.example.ejem11_conectarconserversocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket serverSocket = new ServerSocket(4444);
			Socket socket=serverSocket.accept();
			InputStream is=socket.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);	
				){
				
			Persona mensaje=null;
			do
			{
				mensaje=(Persona) ois.readObject();
				System.out.println("Mensaje del cliente: "+mensaje);
			}while(mensaje.nombre().equalsIgnoreCase("fin")==false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}

}
