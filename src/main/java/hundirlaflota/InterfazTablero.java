package hundirlaflota;

/***
 * Interfaz para la clase Tablero
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public interface InterfazTablero {
	public int[][] getTablero();
	public int getCasilla(int fila, int columna);
	public void setCasilla(int fila, int columna, int valor);
}
