package hundirlaflota;

import java.io.IOException;
import java.util.ArrayList;

public class Jugador {

	protected Coordenadas coord;
	protected InterfazTablero tableroataque, tablerodefensa;
	protected boolean direcciones[] = {true, true, true, true};
	protected ArrayList<Barco> barcossinponer = new ArrayList<Barco>();
	protected ArrayList<Barco> barcospuestos = new ArrayList<Barco>();
	
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
	
	public void ponerBarcos() throws IOException {
		int bucle = 0;
		while(!getBarcoSinPoner().isEmpty()) {
			while(bucle < getBarcoSinPoner().size()) {
				System.out.println((bucle + 1) + "- Longitud " + getBarcoSinPoner().get(bucle).getLongitud());
				bucle ++;
			}
			System.out.println("\nQue barco quieres poner?");
			boolean indicecorrecto = false;
			while(!indicecorrecto) {
				pedirLongitud();
				if(((Directa) coord).getLongitud() != -1) {
					ponerBarco(getBarcoSinPoner().get(getLongitud() - 1).getLongitud());
					indicecorrecto = true;
				} else {
					System.out.println("Indice incorrecto. Vuelve a ponerlo:");
				}
			}
			imprimirTableros();
			bucle = 0;
		}
	}
	
	public void ponerBarco(int longitud) throws IOException {
		boolean coordenadacorrecta;
		boolean puedeponerse = false;
		
		System.out.print("Introducir cordenada inicial del barco:\n");
		while(!puedeponerse) {
			coordenadacorrecta = false;
			while(!coordenadacorrecta) {
				((Directa) coord).setCoordenada();
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
		
		boolean finbucle = false;
		String mensaje = "";
		int casilla;

		System.out.print("Introducir cordenada de disparo:\n");
		while(!finbucle) {
			boolean coordenadacorrecta = false;
			while(!coordenadacorrecta) {
				((Directa) coord).setCoordenada();
				if(coord.getCoordenadaX() != -1 && coord.getCoordenadaY() != -1) {
					coordenadacorrecta = true;
				} else {
					System.out.print("Coordenada incorrecta (inexistente o fuera del tablero). "
							+ "Vueve a introducir la coordenada: \n");
				}
			}
			
			System.out.println(coord.getCoordenadaX());
			System.out.println(coord.getCoordenadaY());
			System.out.println(this.tableroataque.getCasilla(coord.getCoordenadaX(), coord.getCoordenadaY()));
			
			if(this.tableroataque.getCasilla(coord.getCoordenadaX(), coord.getCoordenadaY()) != 0) {
				casilla = 2;
			} else {
				casilla = jugadordefensa.getTablerodefensa().getCasilla(coord.getCoordenadaX(), coord.getCoordenadaY());
			}
			
			switch(casilla) {
			case 0:
				this.getTableroataque().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), casilla + 1);
				mensaje = "Agua";
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
				if(jugadordefensa.getBarcosPuestos().get(i).getCoordenadas().isEmpty()) {
					mensaje = mensaje + " y HUNDIDO";
				}
				
				jugadordefensa.getTablerodefensa().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), 2);
				
				finbucle = true;
				break;
			case 2:
				System.out.println("Ya has disparado aquí. vuelve a disparar");
				break;
			}
		}

		System.out.print(mensaje + "\n");
		
	}
	
	public boolean comprobarDerrota() {
		boolean flag = true;
		for(int i = 0; i < this.getBarcosPuestos().size(); i++) {
			if(!this.getBarcosPuestos().get(i).getCoord().isEmpty()) {
				flag = false;
			}
		}
		return flag;
	}
	
	public void imprimirTableros() throws IOException {
		
		System.out.print(" ");
		for(int i = 0; i < 10; i++) {
			System.out.print(" " + (i+1));
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < 10; i++) {
			System.out.print(Character.toString((char) i+65));
			for(int j = 0; j < 10; j++) {
				switch(this.getTableroataque().getCasilla(i, j)) {
					case 0:
						System.out.print(" ·");
						break;
					case 1:
						System.out.print(" ~");
						break;
					case 2:
						System.out.print(" *");
						break;
				}
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		
		System.out.print(" ");
		for(int i = 0; i < 10; i++) {
			System.out.print(" " + (i+1));
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < 10; i++) {
			System.out.print(Character.toString((char) i+65));
			for(int j = 0; j < 10; j++) {
				switch(this.getTablerodefensa().getCasilla(i, j)) {
					case 0:
						System.out.print(" ~");
						break;
					case 1:
						System.out.print(" +");
						break;
					case 2:
						System.out.print(" *");
						break;
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
	}
	
	public void pedirLongitud() throws IOException {
		((Directa) coord).setLongitud(this.barcossinponer.size());
	}
	
	public int getLongitud() {
		return ((Directa) coord).getLongitud();
	}
	
	public InterfazTablero getTableroataque() {
		return tableroataque;
	}

	public InterfazTablero getTablerodefensa() {
		return tablerodefensa;
	}
	
	public ArrayList<Barco> getBarcoSinPoner() {
		return this.barcossinponer;
	}
	
	public ArrayList<Barco> getBarcosPuestos() {
		return this.barcospuestos;
	}


}
