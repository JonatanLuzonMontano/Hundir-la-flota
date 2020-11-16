package hundirlaflota;

import java.util.ArrayList;

/***
 * Clase encargada de guardar los datos de los barcos
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public class Barco {
	
	public int longitud; //indica la longitud del barco
	
	public ArrayList<Coordenadas> coord = new ArrayList<Coordenadas>(); //lista con las coordenadas que ocupa el barco dentro del tablero
	
	public Barco(int longitud) {
		this.longitud = longitud;
	}
	
	//getters y setters
	
	public int getLongitud() {
		return longitud;
	}
	
	public ArrayList<Coordenadas> getCoord() {
		return coord;
	}

	public void añadirCoordenada(int x, int y) {
		coord.add(new CoordenadaBarco(x, y));
	}
}
