package hundirlaflota;

import java.util.ArrayList;

public class Jugador {

	Coordenadas coord;
	Tablero tableroataque, tablerodefensa;
	boolean direcciones[] = {true, true, true, true};
	ArrayList<Integer> barcos = new ArrayList<Integer>();
	
	public Jugador(InterfazTeclado teclado) {
		this.coord = new Directa(teclado);
		tableroataque = new Tablero();
		tablerodefensa = new Tablero();
		barcos.add(2);
		barcos.add(3);
		barcos.add(4);
		barcos.add(5);
		// TODO Auto-generated constructor stub
	}

	public void comprovarDireccion(int longitud, int x, int y) {
		for(int i = 0; i < longitud; i++) {
			if(coord.getCoordenadaY()-i < 0) {
				direcciones[0] = false;
			}
			if(coord.getCoordenadaY()+i > 9) {
				direcciones[0] = false;
			}
			if(coord.getCoordenadaX()-i < 0) {
				direcciones[0] = false;
			}
			if(coord.getCoordenadaX()+i > 9) {
				direcciones[0] = false;
			}
		}
		
	}

	public boolean[] getDirecciones() {
		// TODO Auto-generated method stub
		return direcciones;
	}

}