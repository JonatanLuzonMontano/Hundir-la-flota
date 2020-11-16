package hundirlaflota;

/***
 * Clase de coordenada que usan los barcos para guardar su posición en el tabero.
 * Al contrario que la clase Directa, esta no tiene ni la dirección ni el índicie longitud del barco.
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public class CoordenadaBarco implements Coordenadas {
	
	int x, y; //variables que guardan las coordenadas del tablero
	
	CoordenadaBarco(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//getters
	
	@Override
	public int getCoordenadaX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getCoordenadaY() {
		// TODO Auto-generated method stub
		return y;
	}


}
