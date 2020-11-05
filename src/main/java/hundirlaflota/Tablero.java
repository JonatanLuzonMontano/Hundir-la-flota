package hundirlaflota;

public class Tablero {
	int tablero[][] = new int[10][10];
	
	public Tablero() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tablero[i][j] = 0;
			}
		}
	}
	
	public int[][] getTablero(){
		return tablero;
	}
	
	public int getCasilla(int fila, int columna) {
		return tablero[fila][columna];
	}
	
	public void setCasilla(int fila, int columna, int valor) {
		
	}
	
}
