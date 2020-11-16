package hundirlaflota;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que contiene el algoritmo del juego
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public class Juego {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		
		//creamos los jugadores
		Jugador j1 = new Jugador(new Teclado());
		Jugador j2 = new Jugador(new Teclado());
		
		//los añadimos a una array que se encargará de gestionar los turnos
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		
		boolean findeljuego = false;
		
		//Primer jugador introduce sus barcos
		jugadores.get(0).imprimirTableros();
		jugadores.get(0).ponerBarcos();
		
		//Segundo jugador introduce sus barcos
		jugadores.get(1).imprimirTableros();
		jugadores.get(1).ponerBarcos();
		
		//mientras no se cumpla la condición de fin de juego, se seguirá ejecutando en bucle
		while(!findeljuego) {

			jugadores.get(0).imprimirTableros(); //visualizamos los tableros
			jugadores.get(0).disparar(jugadores.get(1)); //el primer jugador dispara al segundo
			
			if(jugadores.get(1).comprobarDerrota()) { //se comprueba si se ha ganado
				System.out.println("HAS GANADO");
				findeljuego = true;
			}
			
			//se intercambian las posiciones de los jugadores para el siguiente turno
			jugadores.add(jugadores.get(0));
			jugadores.remove(0);
			
		}
	}

}
