import java.util.*;

/**
 * <code>Tablero</code>, encapsula los métodos y atributos de un tablero. Entre ellas
 * actualizar la ubicación del jugador, revisar si el juego ha terminado y revisar si el
 * jugador ha caído en escalera o serpiente.
 */
public class Tablero {

    // Dimensión del tablero
    private int filas, columnas;
    private int ubicacion = 0;
    // El trabajo de shortcutsMap es mapear casillas (int) a otras casillas (int). En efecto
    // codificando el comportamiento de una escalera o serpiente.
    private Map<Integer, Integer> shortcutsMap = new HashMap<>();

    private ArrayList<Casilla> casillas;

    /**
     * El constructor de Tablero inicializa el contenido del mismo (cada elemento de casillas),
     * le asigna una ubicación/valor y una escalera o serpiente.
     */
    public Tablero(int filas, int columnas) {
        this.filas = filas; this.columnas = columnas;
        casillas = new ArrayList<>(filas*columnas);

        createShortcuts();
        System.out.printf("%d atajos\n", shortcutsMap.size());

        for (int i = 0; i <= filas*columnas; i++) {
            int shortcut = shortcutsMap.getOrDefault(i, -1);
            casillas.add(new Casilla(shortcut));
        }
    }

    /**
     * Actualiza la ubicación del jugador
     * @param offset, int, número de casillas a mover.
     */
    public void mover(int offset) {
        ubicacion += offset;
    }

    /**
     * Revisa si la casilla dónde está el jugador actual tiene una serpiente o escalera,
     * si es el caso.
     * @return int si la casilla tiene un atajo | -1 en caso contrario.
     */
    public int isEscaleraOrSerpiente() {
        if (ubicacion >= filas*columnas) {
            return -1;
        }
        return casillas.get(ubicacion).getShortcut();
    }

    /**
     * Retorna la ubicación actual del jugador en el tablero.
     * @return int
     */
    public int getUbicacion() { return ubicacion; }

    /**
     * El juego termina si se alcanza una ubicación >= 25
     * @return boolean.
     */
    public boolean gameOver() {
        return ubicacion >= filas*columnas;
    }

    /**
     * Inicializa los atajos, primero crea una lista con todos los valores posibles
     * de las casillas, los revuelve y selecciona una porción de ellos (33%) para ser
     * atajos.
     */
    private void createShortcuts() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<filas*columnas; i++) list.add(i);
        Collections.shuffle(list);

        // shortcutsMap almacena partida => llegada. Es bueno que
        // no se repita ni la partida ni la llegada en los atajos generados.
        for (int i=1; i < 2*Math.round((filas*columnas)*0.33); i+=2)
            shortcutsMap.put(list.get(i), list.get(i-1));

    }
}
