package hundirlaflota;

public interface InterfazTablero {
	public int[][] getTablero();
	public int getCasilla(int fila, int columna);
	public void setCasilla(int fila, int columna, int valor);
}
