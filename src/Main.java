import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase principal del juego, se encarga de realizar el bucle y "orquestrar" las clases
 */
public class Main {
    private static int ubicacion=0;
    public static void main(String[] args) {
        Map<Integer, Integer> shortcuts = Map.of(3,11,6,17,9,18,10,12,14,4,19,8,22,20,24,16);
        while (ubicacion < 25) { // Mientras que el juego no haya terminado...
            int dados = ThreadLocalRandom.current().nextInt(1,7); System.out.printf("Dado arroja %d\n", dados);
             ubicacion += dados; System.out.printf("Jugador avanza a cuadro %d\n", ubicacion); // Actualizar ubicación según los dados.
            int ubicacion2 = shortcuts.containsKey(ubicacion) ? shortcuts.get(ubicacion) : ubicacion;
            if (ubicacion2 > ubicacion) { System.out.printf("Jugador sube por escalera al cuadro %d\n", ubicacion2);}
            else if (ubicacion2 < ubicacion) {System.out.printf("Jugador baja por serpiente al cuadro %d\n",ubicacion2);}
            ubicacion = ubicacion2;
        }
        System.out.print("Jugador supera el cuadro 25\nFin");
    }
}
