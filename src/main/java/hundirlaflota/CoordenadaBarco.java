package hundirlaflota;

/***
 * Clase de coordenada que usan los barcos para guardar su posici�n en el tabero.
 * Al contrario que la clase Directa, esta no tiene ni la direcci�n ni el �ndicie longitud del barco.
 * @author Jonat�n Luz�n Monta�o 1281175
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
