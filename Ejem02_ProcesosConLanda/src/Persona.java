
public record Persona(String nombre, int edad) implements Corredor {
    @Override
    public void correr() {
        System.out.println(nombre + " está corriendo.");
    }
}