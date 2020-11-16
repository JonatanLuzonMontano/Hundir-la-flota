package hundirlaflota;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que contiene los tableros, barcos y metodos que necesitará un jugador para jugar
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public class Jugador {

	protected Coordenadas coord; //coordenadas introducidas por teclado
	protected InterfazTablero tableroataque, tablerodefensa; //ambos tableros, de ataque y defensa
	protected boolean direcciones[] = {true, true, true, true}; //matriz con las direcciones posibles y si se puede o no poner el barco en esa dirección
	protected ArrayList<Barco> barcossinponer = new ArrayList<Barco>(); //Lista de barcos que aún quedan por poner
	protected ArrayList<Barco> barcospuestos = new ArrayList<Barco>(); //Lista de barcos que ya se han puesto
	
	public Jugador(InterfazTeclado teclado) {
		this.coord = new Directa(teclado);
		tableroataque = new Tablero();
		tablerodefensa = new Tablero();
		barcossinponer.add(new Barco(2));
		barcossinponer.add(new Barco(3));
		barcossinponer.add(new Barco(4));
		barcossinponer.add(new Barco(5));
	}

	//comprobamos las direcciones hacia las que podemos poner el barco que deseamos colocar.
	//Aquellas hacia las que no se pueda, las ponemos a false
	//En esta función solo comprobamos que el barco no se salga del tablero
	public void comprovarDireccion(int longitud, int x, int y) {
		inicializarDirecciones(); //inicializamos las direcciones a true de posibles comprovaciones anteriores
		for(int i = 0; i < longitud; i++) { //recoremos todas las direcciones (arriba, abajo, derecha, izquierda)
											//y comprobamos que no nos salimos de los límites del tablero

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
		
	//Comprobamos que, hacia las direcciones en las que podemos poner el barco calculadas
	//en el método comprovarDireccion() no haya ningún otro barco colocado
	public void comprovarObstaculos(int longitud, int x, int y) {
		for(int i = 0; i < direcciones.length; i++) { //recorremos la matriz de direcciones
			if(direcciones[i]) { //si la dirección es true (o sea, se puede ir en esa dirección)......
				for(int j = 0; j < longitud; j++) { //recorremos el tablero hasta la longitud del barco por poner
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

	//inicializamos las direciones a true cada vez que deseamos poner un barco nuevo o introducimos una dirección nueva hacia la que poner el barco
	public void inicializarDirecciones() {
		for(int i = 0; i < direcciones.length; i++) {
			direcciones[i] = true;
		}
	}
	
	//función encargada de poner el los barcos
	public void ponerBarcos() throws IOException {
		int bucle = 0;
		while(!getBarcoSinPoner().isEmpty()) { //miramos si tenemos barcos que no hemos puesto
			while(bucle < getBarcoSinPoner().size()) { //imprimimos la lista de barcos que nos quedan por poner
				System.out.println((bucle + 1) + "- Longitud " + getBarcoSinPoner().get(bucle).getLongitud()); 
				bucle ++;
			}
			System.out.println("\nQue barco quieres poner?");
			boolean indicecorrecto = false;
			while(!indicecorrecto) {
				pedirLongitud(); //pedimos por teclado el barco que queremos poner
				if(((Directa) coord).getLongitud() != -1) { //comprobamos que sea un valor válido
					ponerBarco(getBarcoSinPoner().get(getLongitud() - 1).getLongitud()); //si lo es, ponemos el barco
					indicecorrecto = true;
				} else {
					System.out.println("Indice incorrecto. Vuelve a ponerlo:"); //si no, volvemos a pedir el valor
				}
			}
			imprimirTableros();
			bucle = 0;
		}
	}
	
	//funcion encargada de poner el barco en el tablero
	public void ponerBarco(int longitud) throws IOException {
		boolean coordenadacorrecta;
		boolean puedeponerse = false;
		
		System.out.print("Introducir cordenada inicial del barco:\n");
		while(!puedeponerse) {
			coordenadacorrecta = false;
			while(!coordenadacorrecta) {
				((Directa) coord).setCoordenada(); //pedimos la coordenada incial del barco
				if(coord.getCoordenadaX() != -1 && coord.getCoordenadaY() != -1) { //comprobamos que sea correcta
					coordenadacorrecta = true;
				} else {
					System.out.print("Coordenada incorrecta (inexistente o fuera del tablero). " //si no, la volvemos a pedir
							+ "Vueve a introducir la coordenada: \n");
				}
			}
			
			//trabajamos con la matriz direcciones para determinar hacia donde se puede poner el barco
			comprovarDireccion(longitud, coord.getCoordenadaX(), coord.getCoordenadaY());
			comprovarObstaculos(longitud, coord.getCoordenadaX(), coord.getCoordenadaY());
			
			int i = 0;

			while(i < 4 && !puedeponerse) {
				
				if(this.direcciones[i]) { //comprobamos si hay alguna direccion posible para poner el barco
					puedeponerse = true;
				}
				
				i++;
			}

			if(!puedeponerse) { //si no puede ponerse el barco en esa posición (contando posición y obstaculos) volvemos a pedir la coordenada
				System.out.print("No puede ponerse este barco en estas coordenadas."
						+ " Vuelve a introducir la coordenada: \n");
			}
			
		}
		
		//cuando tenemos una coordenada donde podemos poner el barco...
		ArrayList<Integer> diraux = new ArrayList<Integer>();

		for(int i = 0; i < direcciones.length; i++) { //guardamos en un array los índices de las direcciones correctas
			if(direcciones[i]) {
				diraux.add(i);
			}
		}
		
		for(int i = 0; i < diraux.size(); i++) { //imprimimos la lista de direcciones correctas
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
			
			((Directa) coord).setDireccion(diraux.size()); //pedimos la direccion hacia la que queremos poner el barco
			if(((Directa) coord).getDireccion() != -1) {
				dir = true;
			} else {
				System.out.print("Direccion incorrecta. Introducir de nuevo:\n");
			}
			
		}

		this.barcospuestos.add(new Barco(longitud)); //añadimos el barco que vamos a poner a la lista de barcos puuos
		
		switch(diraux.get(((Directa) coord).getDireccion()-1)){ //segun la dirección que introduzcamos, ponemos el barco en esa dirección
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
		
		while(i < this.barcossinponer.size() && !encontrado) { //buscamos el barco que acabamos de poner en la lista de barcos sin poner...
			if(this.barcossinponer.get(i).getLongitud() == longitud) {
				this.barcossinponer.remove(i); //y lo eliminamos
				encontrado = true;
			}
			
			i++;
		}
	}

	//función encargada de cambiar los tableros con los disparos que hace el jugador
	public void disparar(Jugador jugadordefensa) throws IOException {
		
		boolean finbucle = false;
		String mensaje = "";
		int casilla;

		System.out.print("Introducir cordenada de disparo:\n");
		while(!finbucle) {
			boolean coordenadacorrecta = false;
			while(!coordenadacorrecta) {
				((Directa) coord).setCoordenada(); //introducimos la coordenada
				if(coord.getCoordenadaX() != -1 && coord.getCoordenadaY() != -1) { //comprobamos que sea correcta
					coordenadacorrecta = true;
				} else {
					System.out.print("Coordenada incorrecta (inexistente o fuera del tablero). "//si no, la volvemos a introducir
							+ "Vueve a introducir la coordenada: \n");
				}
			}
			
			if(this.tableroataque.getCasilla(coord.getCoordenadaX(), coord.getCoordenadaY()) != 0) { //comprobamos que la casilla no esté tapada en el tablero de ataque (señal que aún no se ha disparado allí
				casilla = 2;
			} else {
				casilla = jugadordefensa.getTablerodefensa().getCasilla(coord.getCoordenadaX(), coord.getCoordenadaY());
			}
			
			switch(casilla) { //comprobamos el valor del tablero del rival y ponemos ese valor en nuestro tablero de ataque, revelando la información
			case 0: //en caso de que sea agua
				this.getTableroataque().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), casilla + 1); //ponemos agua en el tablero de ataque
				mensaje = "Agua";
				finbucle = true;
				break;
			case 1: //en caso de que sea barco
				this.getTableroataque().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), casilla + 1); //ponemos en el tablero un 2 para indicar que has impactado un barco
				mensaje = "Tocado";
				int i = 0;
				int j = 0;
				boolean encontradobarco = false;
				boolean encontradacasilla = false;
				while(i < jugadordefensa.getBarcosPuestos().size() && !encontradobarco) { //recorremos la lista de barcos del rival
					j = 0;
					while(j < jugadordefensa.getBarcosPuestos().get(i).getCoord().size() && !encontradacasilla) {
						if(jugadordefensa.getBarcosPuestos().get(i).getCoord().get(j).getCoordenadaX() == coord.getCoordenadaX() &&
								jugadordefensa.getBarcosPuestos().get(i).getCoord().get(j).getCoordenadaY() == coord.getCoordenadaY()) { //si coincide con las coordenadas de disparo, salimos de los bucles guardando los ínices
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
				
				jugadordefensa.getBarcosPuestos().get(i).getCoord().remove(j);//eliminamos la coordenada del barco correspondiente
				if(jugadordefensa.getBarcosPuestos().get(i).getCoord().isEmpty()) { //si es la última coordenada, indicamos que hemos hundio el barco
					mensaje = mensaje + " y HUNDIDO";
				}
				
				jugadordefensa.getTablerodefensa().setCasilla(coord.getCoordenadaX(), coord.getCoordenadaY(), 2); //indicamos en el tablerodefensivo del rival que hemos disparado a ese barco
				
				finbucle = true;
				break;
				
			case 2: //en caso de que ya hayas disparado aquí
				System.out.println("Ya has disparado aquí. vuelve a disparar");
				break;
			}
		}

		System.out.print(mensaje + "\n");
		
	}
	
	//función encargada de comprobar que quedan barcos. recorremos la lista de barcos, y si ninguno tiene coordenadas,
	//significa que hemos perdido todos los barcos
	public boolean comprobarDerrota() {
		boolean flag = true;
		for(int i = 0; i < this.getBarcosPuestos().size(); i++) {
			if(!this.getBarcosPuestos().get(i).getCoord().isEmpty()) {
				flag = false;
			}
		}
		return flag;
	}
	
	//imprimimos los tableros
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
