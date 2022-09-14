public class Main {

    private static Tablero tablero = new Tablero();
    private static Jugador jugador = new Jugador();
    public static void main(String[] args) {
        while (!tablero.gameOver()) {
            int ubicacion = tablero.getUbicacion();
            if (tablero.isEscaleraOrSerpiente()) {
                int newUbicacion = tablero.getUbicacion();
                if (newUbicacion > ubicacion) {
                    System.out.printf("Jugador sube por escalera al cuadro %d\n", newUbicacion);
                } else {
                    System.out.printf("Jugador baja por serpiente al cuadro %d\n", newUbicacion);
                }
            }

            int dados = jugador.tirarDados();
            System.out.printf("Dado arroja %d\n", dados);
            tablero.mover(dados);
            ubicacion = tablero.getUbicacion();
            System.out.printf("Jugador avanza a cuadro %d\n", ubicacion);
        }
        System.out.print("Jugador supera el cuadro 25\nFin");
    }
}
