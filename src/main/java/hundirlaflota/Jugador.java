package hundirlaflota;

import java.util.ArrayList;

public class Jugador {

	Coordenadas coord;
	InterfazTablero tableroataque, tablerodefensa;
	boolean direcciones[] = {true, true, true, true};
	ArrayList<Barco> barcossinponer = new ArrayList<Barco>();
	ArrayList<Barco> barcospuestos = new ArrayList<Barco>();
	
	public Jugador(InterfazTeclado teclado) {
		this.coord = new Directa(teclado);
		tableroataque = new Tablero();
		tablerodefensa = new Tablero();
		barcossinponer.add(new Barco(2));
		barcossinponer.add(new Barco(3));
		barcossinponer.add(new Barco(4));
		barcossinponer.add(new Barco(5));
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
		
	public void comprobarObstaculos(int longitud, int x, int y) {
		for(int i = 0; i < direcciones.length; i++) {
			if(direcciones[i]) {
				for(int j = 0; j < longitud; j++) {
					switch(i) {
						case 0:
							if(tablerodefensa.getTablero()[x - j][y] != 0) {
								direcciones[i] = false;
							}
							break;
						case 1:
							if(tablerodefensa.getTablero()[x][y + j] != 0) {
								direcciones[i] = false;
							}
							break;
						case 2:
							if(tablerodefensa.getTablero()[x + j][y] != 0) {
								direcciones[i] = false;
							}
							break;
						case 3:
							if(tablerodefensa.getTablero()[x][y - j] != 0) {
								direcciones[i] = false;
							}
							break;
					}
				}
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
	
	public void setDirecciones(boolean[] newdirecciones) {
		direcciones = newdirecciones;
	}
	
	public InterfazTablero getTableroataque() {
		return tableroataque;
	}

	public void setTableroataque(InterfazTablero tableroataque) {
		this.tableroataque = tableroataque;
	}

	public InterfazTablero getTablerodefensa() {
		return tablerodefensa;
	}

	public void setTablerodefensa(InterfazTablero tablerodefensa) {
		this.tablerodefensa = tablerodefensa;
	}

}
