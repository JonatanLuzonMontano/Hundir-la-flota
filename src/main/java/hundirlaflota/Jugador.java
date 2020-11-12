package hundirlaflota;

import java.io.IOException;
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
		
	public void comprovarObstaculos(int longitud, int x, int y) {
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

	public void ponerBarco(int longitud) throws IOException {
		boolean coordenadacorrecta = false;
		boolean puedeponerse = false;
		
		System.out.print("Introducir cordenada inicia del barco:\n");
		System.out.print("while 1\n");
		while(!puedeponerse) {

			System.out.print("while sub 1\n");
			while(!coordenadacorrecta) {
				coord.setCoordenada();
				if(coord.getCoordenadaX() != -1 && coord.getCoordenadaY() != -1) {
					coordenadacorrecta = true;
				} else {
					System.out.print("Coordenada incorrecta (inexistente o fuera del tablero). "
							+ "Vueve a introducir la coordenada: \n");
				}
			}
			
			comprovarDireccion(longitud, coord.getCoordenadaX(), coord.getCoordenadaY());
			comprovarObstaculos(longitud, coord.getCoordenadaX(), coord.getCoordenadaY());
			
			int i = 0;

			System.out.print("while 2\n");
			while(i < 4 && !puedeponerse) {
				
				if(this.direcciones[i]) {
					puedeponerse = true;
				}
				
				i++;
			}

			if(!puedeponerse) {
				System.out.print("No puede ponerse este barco en estas coordenadas."
						+ " Vuelve a introducir la coordenada: \n");
			}
			
		}
		
		System.out.print("Hacia que dirección quieres poner el barco?\n");
		
		ArrayList<Integer> diraux = new ArrayList<Integer>();

		System.out.print(diraux + "\nfor 1\n");
		for(int i = 0; i < direcciones.length; i++) {
			if(direcciones[i]) {
				diraux.add(i);
			}
		}
		System.out.print(diraux + "\n");
		System.out.print("for 2\n");
		for(int i = 0; i < diraux.size(); i++) {
			switch(diraux.get(i)) {
			
				case 0:
					System.out.print(i+1 + ": Arriba\n");
					break;
				case 1:
					System.out.print(i+1 + ": Derecha\n");
					break;
				case 2:
					System.out.print(i+1 + ": Abajo\n");
					break;
				case 3:
					System.out.print(i+1 + ": Izquierda\n");
					break;
			}
		}
		
		boolean dir = false;
		System.out.print("while 3\n");
		while(!dir) {
			
			((Directa) coord).setDireccion();
			if(((Directa) coord).getDireccion() != -1) {
				dir = true;
			} else {
				System.out.print("Direccion incorrecta. Introducir de nuevo:\n");
			}
			
		}

		System.out.print("for 3\n" + ((Directa) coord).getDireccion() + "\n");
		for(int i = 0; i < longitud; i++) {
			switch(((Directa) coord).getDireccion()){
				case 0:
					this.tablerodefensa.getTablero()[coord.getCoordenadaX() - i][coord.getCoordenadaY()] = 1;
					break;
				case 1:
					this.tablerodefensa.getTablero()[coord.getCoordenadaX()][coord.getCoordenadaY() + i] = 1;
					break;
				case 2:
					this.tablerodefensa.getTablero()[coord.getCoordenadaX() + i][coord.getCoordenadaY()] = 1;
					break;
				case 3:
					this.tablerodefensa.getTablero()[coord.getCoordenadaX()][coord.getCoordenadaY() - i] = 1;
					break;
			}
		}
		
		for(int i  = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(tablerodefensa.getCasilla(i, j));
			}
			System.out.print("\n");
		}
		
	}

}
