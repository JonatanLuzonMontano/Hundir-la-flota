package hundirlaflota;

import java.io.IOException;
import java.util.ArrayList;

public class Juego {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Jugador j1 = new Jugador(new Teclado());
		Jugador j2 = new Jugador(new Teclado());
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		
		boolean findeljuego = false;
		
		jugadores.get(0).imprimirTableros();
		jugadores.get(0).ponerBarcos();
		
		jugadores.get(1).imprimirTableros();
		jugadores.get(1).ponerBarcos();
		
		while(!findeljuego) {
			jugadores.get(0).disparar(jugadores.get(1));
			
			if(jugadores.get(1))
			
		}
	}

}
