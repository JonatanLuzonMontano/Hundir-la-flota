package hundirlaflota;

import java.util.ArrayList;

public class Barco {
	
	public int longitud;
	
	public ArrayList<Coordenadas> coord = new ArrayList<Coordenadas>();
	
	public Barco(int longitud) {
		this.longitud = longitud;
	}
	
	public void añadirCoordenada(int x, int y) {
		coord.add(new CoordenadaBarco(x, y));
	}
}
