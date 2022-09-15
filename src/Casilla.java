/**
 * La clase casilla representa cada celda en el tablero.
 */
public class Casilla {
    private final int shortcut;

    /**
     * Cada casilla se inicializa con un shortcut y el valor (posición) de
     * la casilla en el tablero.
     * @param shortcut, representa la casilla destino al caer en una serpiente o escalera.
     */
    public Casilla(int shortcut) {
        this.shortcut = shortcut;
    }

    /**
     * Getter de shortcut
     * @return entero, la casilla a dónde lleva el atajo.
     */
    public int getShortcut() {
        return shortcut;
    }
}
