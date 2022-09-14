/**
 * Clase principal del juego, se encarga de realizar el bucle y "orquestrar" las clases
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

            tablero.mover(dados); // Actualizar ubicación según los dados.
            System.out.printf("Jugador avanza a cuadro %d\n", tablero.getUbicacion());

            // Chequeo si la ubicación actual contiene una escalera o serpiente...
            int atajo = tablero.isEscaleraOrSerpiente();
            if (atajo != -1) {
                // ...si es se calcula cuanto debe moverse...
                int offset = atajo - tablero.getUbicacion();
                tablero.mover(offset);
                // ...si el offset es positivo entonces es una escalera, serpiente en caso contrario...
                if (offset > 0) {
                    System.out.printf("Jugador sube por escalera al cuadro %d\n", tablero.getUbicacion());
                } else {
                    //...si no entonces era una serpiente.
                    System.out.printf("Jugador baja por serpiente al cuadro %d\n", tablero.getUbicacion());
                }
            }
        }
        System.out.print("Jugador supera el cuadro 25\nFin");
    }
}
