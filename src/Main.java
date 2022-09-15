/**
 * Clase principal del juego, se encarga de realizar el bucle y "orquestrar" las clases
 */
public class Main {

    private static Tablero tablero;
    private static Jugador jugador = new Jugador();
    public static void main(String[] args) {

        if (validArgs(args)) {
            int filas = Integer.parseInt(args[0]);
            int columnas = Integer.parseInt(args[1]);
            tablero = new Tablero(filas, columnas);
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
            System.out.printf("Jugador supera el cuadro %d\nFin", filas*columnas);
        }
        else {
            System.out.println("Argumentos inválidos. Uso: java Main.java FILAS COLUMNAS");
            System.exit(-1);
        }
    }

    /**
     * Checks that the CLI arguments passed are valid:
     * args[0] => number of rows for the board.
     * args[1] => number of columns for the board.
     * @param args, list of string with the arguments
     * @return true if args are correct, false otherwise.
     */
    private static boolean validArgs(String[] args) {
        if (args.length != 2) {
            return false;
        }

        try {
            int filas = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);

            // Minimo tamaño 1x1
            if (filas <= 0 || cols <= 0) {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
