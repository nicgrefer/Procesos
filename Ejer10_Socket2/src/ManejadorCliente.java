import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ManejadorCliente implements Runnable {
    private Socket socket;
    private Usuario usuario;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean conectado = true;

    public ManejadorCliente(Socket socket, Usuario usuario, ObjectInputStream ois, ObjectOutputStream oos) {
        this.socket = socket;
        this.usuario = usuario;
        this.ois = ois;
        this.oos = oos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void run() {
        try {
            while (conectado) {
                String mensaje = (String) ois.readObject();
                
                if (mensaje.equalsIgnoreCase("fin")) {
                    conectado = false;
                    break;
                }
                
                String mensajeCompleto = usuario.getNombre() + ": " + mensaje;
                System.out.println("Reenviando mensaje: " + mensajeCompleto);
                Servidor.difundirMensaje(mensajeCompleto, usuario);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Mensaje no válido del cliente " + usuario.getNombre());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la conexión con el cliente " + usuario.getNombre());
        } finally {
            try {
                ois.close();
                oos.close();
                socket.close();
                Servidor.removerCliente(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarMensaje(String mensaje) {
        try {
            oos.writeObject(mensaje);
            oos.flush();
        } catch (IOException e) {
            System.out.println("Error al enviar mensaje al cliente " + usuario.getNombre());
            conectado = false;
        }
    }
}