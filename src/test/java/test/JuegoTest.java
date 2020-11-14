package test;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import hundirlaflota.Jugador;

class JuegoTest {

	@Test
	public void Juego1() throws IOException {
		ArrayList<String> coord1 = new ArrayList<String>();
		coord1.add("4");
		coord1.add("");
		coord1.add("a-12");
		coord1.add("E5");
		coord1.add("4");
		coord1.add("3");
		coord1.add("D6");
		coord1.add("3");
		coord1.add("2");
		coord1.add("c7");
		coord1.add("2");
		coord1.add("1");
		coord1.add("b8");
		coord1.add("1");
		coord1.add("W12");
		coord1.add("j1");
		coord1.add("j2");
		coord1.add("j2");
		coord1.add("j3");
		coord1.add("j4");
		coord1.add("j5");
		coord1.add("j6");
		coord1.add("j7");
		coord1.add("j8");
		coord1.add("j9");
		coord1.add("j10");
		coord1.add("h1");
		coord1.add("h2");
		coord1.add("e12");
		coord1.add("h3");
		coord1.add("h4");
		
		ArrayList<String> coord2 = new ArrayList<String>();
		coord2.add("5");
		coord2.add("4");
		coord2.add("w12");
		coord2.add("e12");
		coord2.add("a1");
		coord2.add("6");
		coord2.add("!");
		coord2.add("1");
		coord2.add("3");
		coord2.add("j10");
		coord2.add("2");
		coord2.add("2");
		coord2.add("e5");
		coord2.add("3");
		coord2.add("1");
		coord2.add("e5");
		coord2.add("a10");
		coord2.add("1");
		coord2.add("b8");
		coord2.add("a8");
		coord2.add("e1");
		coord2.add("e2");
		coord2.add("e3");
		coord2.add("e4");
		coord2.add("e5");
		coord2.add("d6");
		coord2.add("e6");
		coord2.add("f6");
		coord2.add("g6");
		coord2.add("c7");
		coord2.add("c8");
		coord2.add("c9");
		
		Jugador j1 = new Jugador(new MockTeclado(coord1));
		Jugador j2 = new Jugador(new MockTeclado(coord2));
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		
		boolean findeljuego = false;
		
		jugadores.get(0).imprimirTableros();
		jugadores.get(0).ponerBarcos();
		
		jugadores.get(1).imprimirTableros();
		jugadores.get(1).ponerBarcos();
		
		while(!findeljuego) {

			jugadores.get(0).imprimirTableros();
			jugadores.get(0).disparar(jugadores.get(1));
			
			if(jugadores.get(1).comprobarDerrota()) {
				System.out.println("HAS GANADO");
				findeljuego = true;
			}
			
			jugadores.add(jugadores.get(0));
			jugadores.remove(0);
			
		}
	}
}
