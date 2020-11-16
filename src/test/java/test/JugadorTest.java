package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import hundirlaflota.Barco;
import hundirlaflota.Jugador;
import hundirlaflota.Teclado;

/**
 * Test de la case Jugador
 * @author Jonatán Luzón Montaño 1281175
 *
 */
class JugadorTest {
	
	//Comprovamos que se inicializa bien la matriz
	@Test
	void inicializarDirecciones() throws IOException { 
		
		MockJugador j = new MockJugador(new Teclado());
		j.comprovarDireccion(2, 0, 0);
		j.inicializarDirecciones();
		
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	void comprovarDireccion() throws IOException {
		
		MockJugador j = new MockJugador(new Teclado());

		//Barco longitud 2
		//a1
		j.comprovarDireccion(2, 0, 0);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//a10
		j.comprovarDireccion(2, 0, 9);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//j1
		j.comprovarDireccion(2, 9, 0);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//j10
		j.comprovarDireccion(2, 9, 9);
		assertTrue(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//b2
		j.comprovarDireccion(2, 1, 1);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//b9
		j.comprovarDireccion(2, 1, 8);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//i2
		j.comprovarDireccion(2, 8, 1);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//i9
		j.comprovarDireccion(2, 8, 8);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//e5
		j.comprovarDireccion(2, 4, 4);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
		//Barco longitud 3
		//b2
		j.comprovarDireccion(3, 1, 1);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//b9
		j.comprovarDireccion(3, 1, 8);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//i2
		j.comprovarDireccion(3, 8, 1);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//i9
		j.comprovarDireccion(3, 8, 8);
		assertTrue(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//c3
		j.comprovarDireccion(3, 2, 2);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//c8
		j.comprovarDireccion(3, 2, 7);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//h3
		j.comprovarDireccion(3, 7, 2);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//h8
		j.comprovarDireccion(3, 7, 7);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//e5
		j.comprovarDireccion(3, 4, 4);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
		//Barco longitud 4
		//c3
		j.comprovarDireccion(4, 2, 2);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//c8
		j.comprovarDireccion(4, 2, 7);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//h3
		j.comprovarDireccion(4, 7, 2);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//h8
		j.comprovarDireccion(4, 7, 7);
		assertTrue(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//d4
		j.comprovarDireccion(4, 3, 3);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//d7
		j.comprovarDireccion(4, 3, 6);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//g4
		j.comprovarDireccion(4, 6, 3);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//g7
		j.comprovarDireccion(4, 6, 6);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//e5
		j.comprovarDireccion(4, 4, 4);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
		//Barco longitud 5
		//d4
		j.comprovarDireccion(5, 3, 3);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//d7
		j.comprovarDireccion(5, 3, 6);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//g4
		j.comprovarDireccion(5, 6, 3);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		//g7
		j.comprovarDireccion(5, 6, 6);
		assertTrue(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//e5
		j.comprovarDireccion(5, 4, 4);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//e6
		j.comprovarDireccion(5, 4, 5);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//f5
		j.comprovarDireccion(5, 5, 4);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//f6
		j.comprovarDireccion(5, 5, 5);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	void comprobarObstaculos() throws IOException {
		int tablerodefensa[][] = {{0,1,0,0,0,0,0,0,0,0},
								  {1,0,0,0,0,0,0,1,0,0},
								  {0,1,0,0,0,0,1,0,1,0},
								  {0,0,0,0,1,0,0,0,0,0},
								  {0,0,0,0,1,0,0,0,1,0},
								  {0,1,1,0,0,1,0,0,0,1},
								  {0,0,0,0,1,0,0,0,1,0},
								  {0,0,0,0,1,0,0,0,0,0},
								  {1,0,0,0,1,0,0,0,0,0},
								  {0,0,0,0,1,0,0,0,1,0}};
		
		boolean nuevasdirecciones[] = new boolean[4];
		MockJugador j = new MockJugador(new Teclado());
		j.setTablerodefensa(new MockTablero(tablerodefensa));

		
		nuevasdirecciones[0] = true;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(2, 5, 4);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = true;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(5, 5, 4);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = false;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = false;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(3, 1, 1);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = false;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(5, 0, 5);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = false;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = false;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(5, 2, 0);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = false;
		nuevasdirecciones[1] = false;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(4, 2, 7);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = true;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(2, 5, 8);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = true;
		nuevasdirecciones[1] = false;
		nuevasdirecciones[2] = true;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(4, 5, 8);
		assertFalse(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = true;
		nuevasdirecciones[1] = true;
		nuevasdirecciones[2] = false;
		nuevasdirecciones[3] = false;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(3, 9, 0);
		assertFalse(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
		nuevasdirecciones[0] = true;
		nuevasdirecciones[1] = false;
		nuevasdirecciones[2] = false;
		nuevasdirecciones[3] = true;
		j.setDirecciones(nuevasdirecciones);
		
		j.comprovarObstaculos(3, 9, 9);
		assertTrue(j.getDirecciones()[0]);
		assertFalse(j.getDirecciones()[1]);
		assertFalse(j.getDirecciones()[2]);
		assertFalse(j.getDirecciones()[3]);
		
	}

	//valores límite, frontera y partición equivalente
	@Test
	void disparar() throws IOException {
		
		int tablerodefensa[][] = {	{0,0,0,1,1,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,1,0,0,0},
									{0,0,0,0,0,0,1,0,0,0},
									{0,0,0,0,0,0,1,0,0,0},
									{0,0,0,0,0,0,0,0,0,1},
									{0,0,1,1,1,1,0,0,0,1},
									{0,0,0,0,0,0,0,0,0,1},
									{0,0,0,0,0,0,0,0,0,1},
									{0,0,0,0,0,0,0,0,0,1}};
		
		int tableroataque[][] = {	{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0}};
		
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("k12");
		coord.add("000");
		coord.add("a1");
		coord.add("e4");
		coord.add("h9");
		coord.add("a4");
		coord.add("a5");
		coord.add("j10");
		coord.add("g3");
		coord.add("g4");
		MockJugador jugadorataque = new MockJugador(new MockTeclado(coord));
		MockJugador jugadordefensa = new MockJugador(new MockTeclado(coord));
		
		jugadorataque.setTableroataque(new MockTablero(tableroataque));
		jugadordefensa.setTablerodefensa(new MockTablero(tablerodefensa));

		Barco lon2 = new Barco(2);
		Barco lon3 = new Barco(3);
		Barco lon4 = new Barco(4);
		Barco lon5 = new Barco(5);
		
		lon2.añadirCoordenada(0, 3);
		lon2.añadirCoordenada(0, 4);
		
		lon3.añadirCoordenada(2, 6);
		lon3.añadirCoordenada(3, 6);
		lon3.añadirCoordenada(4, 6);
		
		lon4.añadirCoordenada(6, 2);
		lon4.añadirCoordenada(6, 3);
		lon4.añadirCoordenada(6, 4);
		lon4.añadirCoordenada(6, 5);

		lon5.añadirCoordenada(5, 9);
		lon5.añadirCoordenada(6, 9);
		lon5.añadirCoordenada(7, 9);
		lon5.añadirCoordenada(8, 9);
		lon5.añadirCoordenada(9, 9);
		
		ArrayList<Barco> listabarcos = new ArrayList<Barco>();
		
		listabarcos.add(lon2);
		listabarcos.add(lon3);
		listabarcos.add(lon4);
		listabarcos.add(lon5);
		
		jugadordefensa.setBarcoPuestos(listabarcos);
		
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(0, 0), 1);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(4, 3), 1);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(7, 8), 1);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(0, 3), 2);
		assertEquals(jugadordefensa.getBarcosPuestos().get(0).getCoord().size(), 1);
		assertEquals(jugadordefensa.getTablerodefensa().getCasilla(0, 3), 2);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(0, 4), 2);
		assertEquals(jugadordefensa.getBarcosPuestos().get(0).getCoord().size(), 0);
		assertEquals(jugadordefensa.getTablerodefensa().getCasilla(0, 4), 2);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(9, 9), 2);
		assertEquals(jugadordefensa.getBarcosPuestos().get(3).getCoord().size(), 4);
		assertEquals(jugadordefensa.getTablerodefensa().getCasilla(9, 9), 2);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(6, 2), 2);
		assertEquals(jugadordefensa.getBarcosPuestos().get(2).getCoord().size(), 3);
		assertEquals(jugadordefensa.getTablerodefensa().getCasilla(6, 2), 2);
		jugadorataque.disparar(jugadordefensa);
		assertEquals(jugadorataque.getTableroataque().getCasilla(6, 3), 2);
		assertEquals(jugadordefensa.getBarcosPuestos().get(2).getCoord().size(), 2);
		assertEquals(jugadordefensa.getTablerodefensa().getCasilla(6, 3), 2);
		
		
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	void ponerBarco() throws IOException {
		int tablerodefensabase[][] = {{0,1,0,0,0,0,0,0,0,0},
				  				  	  {1,0,0,0,0,0,0,1,0,0},
				  					  {0,1,0,0,0,0,1,0,1,0},
				  					  {0,0,0,0,1,0,0,0,0,0},
				  					  {0,0,0,0,1,0,0,0,1,0},
				  					  {0,1,1,0,0,1,0,0,0,1},
				  					  {0,0,0,0,1,0,0,0,1,0},
				  					  {0,0,0,0,1,0,0,0,0,0},
				  					  {1,0,0,0,1,0,0,0,0,0},
				  					  {0,0,0,0,1,0,0,0,1,0}};
		
		int tablerodefensabase2[][] = {	{0,1,0,0,0,0,0,0,0,0},
			  	  						{1,0,0,0,0,0,0,1,0,0},
			  	  						{0,1,0,0,0,0,1,0,1,0},
			  	  						{0,0,0,0,1,0,0,0,0,0},
			  	  						{0,0,0,0,1,0,0,0,1,0},
			  	  						{0,1,1,0,0,1,0,0,0,1},
			  	  						{0,0,0,0,1,0,0,0,1,0},
			  	  						{0,0,0,0,1,0,0,0,0,0},
			  	  						{1,0,0,0,1,0,0,0,0,0},
			  	  						{0,0,0,0,1,0,0,0,1,0}};
		
		int tablerodefensa2[][] = {{0,1,0,0,1,1,0,0,0,0},
			  	  				   {1,0,0,0,0,0,0,1,0,0},
			  					   {0,1,0,0,0,0,1,0,1,0},
			  					   {0,0,0,0,1,0,0,0,0,0},
			  					   {0,0,0,0,1,0,0,0,1,0},
			  					   {0,1,1,1,1,1,0,0,0,1},
			  					   {0,0,0,0,1,0,0,0,1,0},
			  					   {0,0,0,0,1,0,0,0,0,0},
			  					   {1,0,1,0,1,0,0,0,0,1},
			  					   {0,0,1,0,1,0,0,0,1,1}};
		
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("a11");
		coord.add("w5");
		coord.add("356");
		coord.add("a6");
		coord.add("3");
		coord.add("j10");
		coord.add("1");
		coord.add("f4");
		coord.add("2");
		coord.add("i3");
		coord.add("3");
		
		MockJugador j = new MockJugador(new MockTeclado(coord));
		j.setTablerodefensa(new MockTablero(tablerodefensabase2));
		j.ponerBarco(2);
		assertEquals(j.getBarcosPuestos().size(), 1);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 2);
		j.ponerBarco(2);
		assertEquals(j.getBarcosPuestos().size(), 2);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 2);
		j.ponerBarco(2);
		assertEquals(j.getBarcosPuestos().size(), 3);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 2);
		j.ponerBarco(2);
		assertEquals(j.getBarcosPuestos().size(), 4);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 2);
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				assertEquals(j.getTablerodefensa().getTablero()[x][y], tablerodefensa2[x][y]);
			}
		}
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				tablerodefensabase2[x][y] = tablerodefensabase[x][y];
			}
		}
		
		int tablerodefensa3[][] = {{0,1,0,0,0,0,0,0,0,1},
 				   				   {1,0,0,0,0,0,0,1,0,1},
 								   {0,1,0,0,0,0,1,0,1,1},
 								   {0,0,0,0,1,0,0,0,0,0},
 								   {0,0,0,0,1,0,0,0,1,0},
 								   {0,1,1,0,0,1,0,0,0,1},
 								   {0,0,0,0,1,0,0,0,1,0},
 								   {1,1,1,0,1,0,0,0,0,0},
 								   {1,0,0,0,1,0,0,0,0,0},
 								   {0,1,1,1,1,1,1,1,1,0}};
		
		coord.add("j4");
		coord.add("2");
		coord.add("j6");
		coord.add("2");
		coord.add("a10");
		coord.add("1");
		coord.add("h1");
		coord.add("2");
		
		j.setTablerodefensa(new MockTablero(tablerodefensabase2));
		j.ponerBarco(3);
		assertEquals(j.getBarcosPuestos().size(), 5);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 3);
		j.ponerBarco(3);
		assertEquals(j.getBarcosPuestos().size(), 6);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 3);
		j.ponerBarco(3);
		assertEquals(j.getBarcosPuestos().size(), 7);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 3);
		j.ponerBarco(3);
		assertEquals(j.getBarcosPuestos().size(), 8);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 3);
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				assertEquals(j.getTablerodefensa().getTablero()[x][y], tablerodefensa3[x][y]);
			}
		}
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				tablerodefensabase2[x][y] = tablerodefensabase[x][y];
			}
		}
		
		int tablerodefensa4[][] = {{0,1,0,0,0,0,0,0,0,0},
				   				   {1,0,0,0,0,0,0,1,0,1},
								   {0,1,0,0,0,0,1,0,1,1},
								   {1,0,0,0,1,1,1,1,1,1},
								   {1,0,0,0,1,0,0,0,1,1},
								   {1,1,1,0,0,1,0,0,0,1},
								   {1,0,0,0,1,0,0,0,1,0},
								   {0,0,0,0,1,1,1,1,1,0},
								   {1,0,0,0,1,0,0,0,0,0},
								   {0,0,0,0,1,0,0,0,1,0}};
		
		coord.add("b10");
		coord.add("1");
		coord.add("d6");
		coord.add("2");
		coord.add("h9");
		coord.add("1");
		coord.add("g1");
		coord.add("1");
		
		j.setTablerodefensa(new MockTablero(tablerodefensabase2));
		j.ponerBarco(4);
		assertEquals(j.getBarcosPuestos().size(), 9);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 4);
		j.ponerBarco(4);
		assertEquals(j.getBarcosPuestos().size(), 10);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 4);
		j.ponerBarco(4);
		assertEquals(j.getBarcosPuestos().size(), 11);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 4);
		j.ponerBarco(4);
		assertEquals(j.getBarcosPuestos().size(), 12);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 4);
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				assertEquals(j.getTablerodefensa().getTablero()[x][y], tablerodefensa4[x][y]);
			}
		}
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				tablerodefensabase2[x][y] = tablerodefensabase[x][y];
			}
		}
		
		int tablerodefensa5[][] = {{0,1,0,1,1,1,1,1,0,1},
 				   				   {1,0,0,0,0,0,0,1,0,1},
 								   {0,1,0,0,0,0,1,0,1,1},
 								   {0,0,0,0,1,0,0,0,0,1},
 								   {0,0,0,1,1,0,0,0,1,1},
 								   {0,1,1,1,0,1,0,0,0,1},
 								   {0,0,0,1,1,0,0,0,1,0},
 								   {0,0,0,1,1,0,0,0,0,0},
 								   {1,0,0,1,1,1,1,1,1,1},
 								   {0,0,0,0,1,0,0,0,1,0}};
		
		coord.add("e4");
		coord.add("2");
		coord.add("a8");
		coord.add("1");
		coord.add("e10");
		coord.add("1");
		coord.add("i6");
		coord.add("1");
		
		j.setTablerodefensa(new MockTablero(tablerodefensabase2));
		j.ponerBarco(5);
		assertEquals(j.getBarcosPuestos().size(), 13);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 5);
		j.ponerBarco(5);
		assertEquals(j.getBarcosPuestos().size(), 14);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 5);
		j.ponerBarco(5);
		assertEquals(j.getBarcosPuestos().size(), 15);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 5);
		j.ponerBarco(5);
		assertEquals(j.getBarcosPuestos().size(), 16);
		assertEquals(j.getBarcosPuestos().get(j.getBarcosPuestos().size() - 1).getLongitud(), 5);
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				assertEquals(j.getTablerodefensa().getTablero()[x][y], tablerodefensa5[x][y]);
			}
		}
		
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	void ponerBarcos() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("4");
		coord.add("a1");
		coord.add("1");
		coord.add("3");
		coord.add("b1");
		coord.add("2");
		coord.add("1");
		coord.add("j10");
		coord.add("2");
		coord.add("1");
		coord.add("e5");
		coord.add("1");
		MockJugador j = new MockJugador(new MockTeclado(coord));
		j.ponerBarcos();
		assertTrue(j.getBarcoSinPoner().isEmpty());
		assertEquals(j.getBarcosPuestos().size(), 4);
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	void comprovarDerrota() throws IOException {
		ArrayList<String> coord1 = new ArrayList<String>();
		coord1.add("4");
		coord1.add("a1");
		coord1.add("1");
		coord1.add("3");
		coord1.add("b1");
		coord1.add("2");
		coord1.add("1");
		coord1.add("j10");
		coord1.add("2");
		coord1.add("1");
		coord1.add("e5");
		coord1.add("1");
		MockJugador jugadordefensor = new MockJugador(new MockTeclado(coord1));
		jugadordefensor.ponerBarcos();

		ArrayList<String> coord2 = new ArrayList<String>();
		coord2.add("a1");
		coord2.add("a2");
		coord2.add("a3");
		coord2.add("a4");
		coord2.add("a5");
		coord2.add("b1");
		coord2.add("c1");
		coord2.add("d1");
		coord2.add("e1");
		coord2.add("j10");
		coord2.add("j9");
		coord2.add("e5");
		coord2.add("d5");
		coord2.add("c5");
		Jugador jugadoratacante = new Jugador(new MockTeclado(coord2));
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		jugadoratacante.disparar(jugadordefensor);
		
		assertTrue(jugadordefensor.comprobarDerrota());
		
	}

}
