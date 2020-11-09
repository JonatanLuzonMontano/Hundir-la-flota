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
	}

	public void comprovarDireccion(int longitud, int x, int y) {
		inicializarDirecciones();
		for(int i = 0; i < longitud; i++) {

			if(x-i < 0) {
				direcciones[0] = false;
			}
			if(x+i > 9) {
				direcciones[2] = false;
			}
			if(y-i < 0) {
				direcciones[3] = false;
			}
			if(y+i > 9) {
				direcciones[1] = false;
			}
			
		}
		
	}

	public void inicializarDirecciones() {
		for(int i = 0; i < direcciones.length; i++) {
			direcciones[i] = true;
		}
	}
	
	public boolean[] getDirecciones() {
		return direcciones;
	}
	
	public void comprobarObstaculos() {
		
	}

}
