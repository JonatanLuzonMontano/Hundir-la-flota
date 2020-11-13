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
	
	public void ponerBarco(int longitud) throws IOException {
		boolean coordenadacorrecta = false;
		boolean puedeponerse = false;
		
		System.out.print("Introducir cordenada inicia del barco:\n");
		while(!puedeponerse) {

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
		
		ArrayList<Integer> diraux = new ArrayList<Integer>();

		for(int i = 0; i < direcciones.length; i++) {
			if(direcciones[i]) {
				diraux.add(i);
			}
		}
		
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
		while(!dir) {
			
			((Directa) coord).setDireccion();
			if(((Directa) coord).getDireccion() != -1) {
				dir = true;
			} else {
				System.out.print("Direccion incorrecta. Introducir de nuevo:\n");
			}
			
		}

		this.barcospuestos.add(new Barco(longitud));
		
		switch(diraux.get(((Directa) coord).getDireccion()-1)){
			case 0:
				for(int i = 0; i < longitud; i++) {
					this.tablerodefensa.getTablero()[coord.getCoordenadaX() - i][coord.getCoordenadaY()] = 1;
					this.barcospuestos.get(this.barcospuestos.size()-1).añadirCoordenada(coord.getCoordenadaX() - i, coord.getCoordenadaY());
				}
				break;
			case 1:
				for(int i = 0; i < longitud; i++) {
					this.tablerodefensa.getTablero()[coord.getCoordenadaX()][coord.getCoordenadaY() + i] = 1;
					this.barcospuestos.get(this.barcospuestos.size()-1).añadirCoordenada(coord.getCoordenadaX(), coord.getCoordenadaY() + i);
				}
				break;
			case 2:
				for(int i = 0; i < longitud; i++) {
					this.tablerodefensa.getTablero()[coord.getCoordenadaX() + i][coord.getCoordenadaY()] = 1;
					this.barcospuestos.get(this.barcospuestos.size()-1).añadirCoordenada(coord.getCoordenadaX() + i, coord.getCoordenadaY());
				}
				break;
			case 3:
				for(int i = 0; i < longitud; i++) {
					this.tablerodefensa.getTablero()[coord.getCoordenadaX()][coord.getCoordenadaY() - i] = 1;
					this.barcospuestos.get(this.barcospuestos.size()-1).añadirCoordenada(coord.getCoordenadaX(), coord.getCoordenadaY() - i);
				}
				break;
		}
		
		int i = 0;
		boolean encontrado = false;
		
		while(i < this.barcossinponer.size() && !encontrado) {
			if(this.barcossinponer.get(i).getLongitud() == longitud) {
				this.barcossinponer.remove(i);
				encontrado = true;
			}
			
			i++;
		}
	}

	public void disparar(Jugador jugadordefensa) throws IOException {
		
		boolean coordenadacorrecta = false;
		boolean finbucle = false;
		String mensaje = "";

		System.out.print("Introducir cordenada de disparo:\n");
		while(!finbucle) {
			while(!coordenadacorrecta) {
				coord.setCoordenada();
				if(coord.getCoordenadaX() != -1 && coord.getCoordenadaY() != -1) {
					coordenadacorrecta = true;
				} else {
					System.out.print("Coordenada incorrecta (inexistente o fuera del tablero). "
							+ "Vueve a introducir la coordenada: \n");
				}
			}
			
			int casilla = jugadordefensa.getTablerodefensa().getCasilla(coord.getCoordenadaX(), coord.getCoordenadaY());
			
			switch(casilla) {
			case 0:
				this.getTableroataque().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), casilla + 1);
				mensaje = "Agua\n";
				finbucle = true;
				break;
			case 1:
				this.getTableroataque().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), casilla + 1);
				mensaje = "Tocado";
				
				int i = 0;
				int j = 0;
				boolean encontradobarco = false;
				boolean encontradacasilla = false;
				while(i < jugadordefensa.getBarcosPuestos().size() && !encontradobarco) {
					j = 0;
					while(j < jugadordefensa.getBarcosPuestos().get(i).getCoordenadas().size() && !encontradacasilla) {
						if(jugadordefensa.getBarcosPuestos().get(i).getCoordenadas().get(j).getCoordenadaX() == coord.getCoordenadaX() &&
								jugadordefensa.getBarcosPuestos().get(i).getCoordenadas().get(j).getCoordenadaY() == coord.getCoordenadaY()) {
							encontradobarco = true;
							encontradacasilla = true;
						}
						if(!encontradacasilla) {
							j++;
						}
					}
					if(!encontradobarco) {
						i++;
					}
				}
				
				jugadordefensa.getBarcosPuestos().get(i).getCoordenadas().remove(j);
				if(jugadordefensa.getBarcosPuestos().get(i).getCoordenadas().size() == 0) {
					mensaje = mensaje + " y HUNDIDO";
				}
				
				jugadordefensa.getTablerodefensa().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), 2);
				
				finbucle = true;
				break;
			case 2:
				System.out.print("Ya has disparado aquí. vuelve a disparar");
				break;
			}
		}
		
		System.out.print(mensaje);
		
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
	
	public ArrayList<Barco> getBarcoSinPoner() {
		return this.barcossinponer;
	}
	
	public void setBarcoSinPoner(ArrayList<Barco> listabarcos) {
		this.barcossinponer = listabarcos;
	}
	
	public ArrayList<Barco> getBarcosPuestos() {
		return this.barcospuestos;
	}
	
	public void setBarcoPuestos(ArrayList<Barco> listabarcos) {
		this.barcospuestos = listabarcos;
	}


}
