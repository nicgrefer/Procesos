import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ManejadorCliente extends Thread {
    private Socket socket;
    private ObjectInputStream ois;
    private boolean activo = true;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
        try {
            this.ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error al crear ObjectInputStream: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (activo && !socket.isClosed()) {
                try {
                    Usuario usuario = (Usuario) ois.readObject();
                    System.out.println("Mensaje recibido: " + usuario.toString());
                    
                    if (usuario.getNombre().equalsIgnoreCase("fin")) {
                        System.out.println("Cliente solicitó desconexión");
                        activo = false;
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Error: Clase Usuario no encontrada.");
                } catch (IOException e) {
                    if (activo) {
                        System.out.println("Cliente desconectado inesperadamente");
                    }
                    activo = false;
                }
            }
        } finally {
            cerrarConexion();
        }
    }

    private void cerrarConexion() {
        try {
            if (ois != null) ois.close();
            if (socket != null && !socket.isClosed()) socket.close();
            System.out.println("Conexión cerrada para el cliente");
        } catch (IOException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}