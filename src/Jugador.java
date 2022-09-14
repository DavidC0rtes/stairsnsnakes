import java.util.concurrent.ThreadLocalRandom;

/**
 * La clase Jugador describe la única acción que es inherente al jugador: tirar un dado.
 * Puede eliminarse y añadirse a Tablero, pero me gusta seguir el patrón de unica responsabilidad.
 */
public class Jugador {

    /**
     * Genera un número aleatorio entre 1 (inclusivo) y 7 (exclusivo).
     * En caso de implementar múltiples jugadores o tableros concurrentes el uso
     * de ThreadLocalRandom es thread-safe.
     * @return int.
     */
    public int tirarDados() {
        return ThreadLocalRandom.current().nextInt(1,7);
    }
}
