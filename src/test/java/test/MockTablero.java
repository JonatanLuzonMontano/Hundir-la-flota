package test;

import hundirlaflota.InterfazTablero;

public class MockTablero implements InterfazTablero{

	int tablero[][] = new int[10][10];
	
	public MockTablero(int newtablero[][]) {
		tablero = newtablero;
	}
	
	public int[][] getTablero() {
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
	
	public void setTablero(int[][] nuevotablero) {
		this.tablero = nuevotablero;
	}

}
