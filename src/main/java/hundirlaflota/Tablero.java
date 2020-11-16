package hundirlaflota;

/**
 * Clase que contiene el tablero
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public class Tablero implements InterfazTablero{
	int tablero[][] = new int[10][10];
	
	public Tablero() { //inicializamos el tablero a 0
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tablero[i][j] = 0;
			}
		}
	}
	
	//getters y setters
	
	public int[][] getTablero(){
		return tablero;
	}
	
	public int getCasilla(int fila, int columna) {
		return tablero[fila][columna];
	}
	
	public void setCasilla(int fila, int columna, int valor) {
		
		if(valor >= 0 && valor <= 2) {
			tablero[fila][columna] = valor;
		}
	}
	
}
