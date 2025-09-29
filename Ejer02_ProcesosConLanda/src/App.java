public class App {

    public static void main(String[] args) {
        Thread padre = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println("Padre " + i);
                int j = i;
                for (int k = 1; k < 11; k++) {
                    int kFinal = k;
                    Thread hijo = new Thread(() -> System.out.println("Hilo " + j + " proceso " + kFinal));
                    hijo.start();
                }
            }
        }, "Hilo Padre");
        padre.start();
    }
}
