/**
 * Clase principal del juego, se encarga de realizar el bucle y "orquestrar" las clases
 */
public class Main {

    private static Tablero tablero = new Tablero();
    private static Jugador jugador = new Jugador();
    public static void main(String[] args) {
        // Mientras que el juego no haya terminado...
        while (!tablero.gameOver()) {
            int ubicacion = tablero.getUbicacion();

            // Chequeo si la ubicación actual contiene una escalera o serpiente...
            if (tablero.isEscaleraOrSerpiente()) {
                // ...si es así el tablero actualizó la ubicación...
                int newUbicacion = tablero.getUbicacion();
                // ...si la ubicación nueva es mayor a la anterior, entonces era una escalera...
                if (newUbicacion > ubicacion) {
                    System.out.printf("Jugador sube por escalera al cuadro %d\n", newUbicacion);
                } else {
                    //...si no entonces era una serpiente.
                    System.out.printf("Jugador baja por serpiente al cuadro %d\n", newUbicacion);
                }
            }

            // Mecánica básica del juego
            int dados = jugador.tirarDados();
            System.out.printf("Dado arroja %d\n", dados);
            tablero.mover(dados); // Actualizar ubicación según los dados.
            ubicacion = tablero.getUbicacion();
            System.out.printf("Jugador avanza a cuadro %d\n", ubicacion);
        }
        System.out.print("Jugador supera el cuadro 25\nFin");
    }
}
