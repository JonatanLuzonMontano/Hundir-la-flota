package test;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import hundirlaflota.Barco;
import hundirlaflota.Jugador;


/**
 * Test implementado para hacer tests de caja banca de la clase Jugador
 * @author Jonatán Luzón Montaño
 *
 */
class JugadorTestCajaBlanca {

	//Path 1-2-5 coverage del método ponerBarcos()
	@Test
	void path1Test() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		MockJugador jugador = new MockJugador(new MockTeclado(coord));
		jugador.setBarcoSinPoner(new ArrayList<Barco>());
		jugador.ponerBarcos();
	}
	
	//Path 1-2-3-4-5 coverage del método ponerBarcos()
	@Test
	void path2Test() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("1");
		coord.add("a1");
		coord.add("1");
		MockJugador jugador = new MockJugador(new MockTeclado(coord));
		jugador.setBarcoSinPoner(new ArrayList<Barco>());
		jugador.getBarcoSinPoner().add(new Barco(2));
		jugador.ponerBarcos();
	}
	
	//Path 1-2-3-3-4-5 coverage del método ponerBarcos()
	@Test
	void path3Test() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("3");
		coord.add("1");
		coord.add("a1");
		coord.add("1");
		MockJugador jugador = new MockJugador(new MockTeclado(coord));
		jugador.setBarcoSinPoner(new ArrayList<Barco>());
		jugador.getBarcoSinPoner().add(new Barco(2));
		jugador.ponerBarcos();
	}
	
	//looptesting del metodo comprovarDirección
	@Test
	void looptesting() throws IOException {
		Jugador j = new Jugador(new MockTeclado(new ArrayList<String>()));
		j.comprovarDireccion(0, 5, 5); //no entra en el loop
		j.comprovarDireccion(1, 5, 5); //entra 1 vez
		j.comprovarDireccion(2, 5, 5); //entra 2 veces
		j.comprovarDireccion(3, 5, 5); //entra 3 veces
		j.comprovarDireccion(4, 5, 5); //entra 4 (maximo) veces
	}

}
