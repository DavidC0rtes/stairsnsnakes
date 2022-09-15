/**
 * Clase principal del juego, se encarga de realizar el bucle del juego.
 */
public class Main {

    private static Tablero tablero = new Tablero();
    private static Jugador jugador = new Jugador();
    public static void main(String[] args) {
        // Mientras que el juego no haya terminado...
        while (!tablero.gameOver()) {
            // Mecánica básica del juego
            int dados = jugador.tirarDados();
            System.out.printf("Dado arroja %d\n", dados);

            int oldLocation = tablero.getUbicacion();
            if (dados+oldLocation > 25) {
                System.out.printf("!!!!!Jugador excede la casilla 25 por %d unidades\n", (dados+oldLocation)-25);
            }
            tablero.mover(dados); // Actualizar ubicación según los dados.
            System.out.printf("Jugador avanza al cuadro %d\n", tablero.getUbicacion());

            // Chequeo si la ubicación actual contiene una escalera o serpiente...
            int atajo = tablero.isEscaleraOrSerpiente();
            if (atajo != -1) {
                // ...si es así el tablero actualiza la ubicación...
                int offset = atajo - tablero.getUbicacion();
                tablero.mover(offset);
                // ...si la ubicación nueva es mayor a la anterior, entonces era una escalera...
                if (offset > 0) {
                    System.out.printf("Jugador sube por escalera al cuadro %d\n", tablero.getUbicacion());
                } else {
                    //...si no entonces era una serpiente.
                    System.out.printf("Jugador baja por serpiente al cuadro %d\n", tablero.getUbicacion());
                }
            }

        }
        System.out.println("Fin");
    }
}
