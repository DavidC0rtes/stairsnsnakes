import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>Tablero</code>, encapsula los métodos y atributos de un tablero. Entre ellas
 * actualizar la ubicación del jugador, revisar si el juego ha terminado y revisar si el
 * jugador ha caído en escalera o serpiente.
 */
public class Tablero {

    // Dimensión del tablero, ej: un tablero de 25 casillas tiene dimensión/tamaño 5x5.
    private int size = 5;
    private int ubicacion = 0;
    // El trabajo de shortcutsMap es mapear casillas (int) a otras casillas (int). En efecto
    // codificando el comportamiento de una escalera o serpiente.
    private Map<Integer, Integer> shortcutsMap = new HashMap<>() {{
        put(3, 11);
        put(6, 17);
        put(9, 18);
        put(10, 12);
        put(14, 4);
        put(19, 8);
        put(22, 20);
        put(24, 16);
    }};

    private ArrayList<Casilla> casillas = new ArrayList<>((size * size) + 1);

    /**
     * El constructor de Tablero inicializa el contenido del mismo (cada elemento de casillas),
     * le asigna una ubicación/valor y una escalera o serpiente.
     */
    public Tablero() {

        for (int i = 0; i <= size*size; i++) {
            int shortcut = shortcutsMap.getOrDefault(i, -1);
            casillas.add(new Casilla(shortcut));
        }
    }

    /**
     * Actualiza la ubicación del jugador, BONUS. 2: Si la nueva ubicación supera 25,
     * debe retroceder el número de veces que supera esta.
     * @param offset, int, número de casillas a mover.
     */
    public void mover(int offset) {
        if (ubicacion + offset > 25) {
            ubicacion -= (ubicacion+offset) - 25;
        } else {
            ubicacion += offset;
        }
    }

    /**
     * Revisa si la casilla dónde está el jugador actual tiene una serpiente o escalera,
     * si es el caso, actualiza entonces la ubicación de acuerdo al valor donde el atajo
     * lo lleva.
     * @return true si la casilla tiene un atajo | false en caso contrario.
     */
    public int isEscaleraOrSerpiente() {
        int shortcut = casillas.get(ubicacion).getShortcut();
        if (shortcut != -1) {
            return shortcut;
        }

        return -1;
    }

    /**
     * Retorna la ubicación actual del jugador en el tablero.
     * @return int
     */
    public int getUbicacion() { return ubicacion; }

    /**
     * El juego termina si se alcanza una ubicación == 25
     * @return boolean.
     */
    public boolean gameOver() {
        return ubicacion == 25;
    }
}
