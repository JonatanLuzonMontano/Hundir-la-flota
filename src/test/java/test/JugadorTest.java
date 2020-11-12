package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import hundirlaflota.Directa;
import hundirlaflota.InterfazTablero;
import hundirlaflota.Jugador;
import hundirlaflota.Tablero;
import hundirlaflota.Teclado;

class JugadorTest {
	
	@Test
	void inicializarDirecciones() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("a1");
		Jugador j = new Jugador(new MockTeclado(coord));
		j.comprovarDireccion(2, 0, 0);
		j.inicializarDirecciones();
		
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		
	}
	
	@Test
	void comprovarDireccion() throws IOException {
		
		Jugador j = new Jugador(new Teclado());

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
		Jugador j = new Jugador(new Teclado());
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

	@Test
	void disparar() {
		
	}
	
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
		
		Jugador j = new Jugador(new MockTeclado(coord));
		j.setTablerodefensa(new MockTablero(tablerodefensabase2));
		j.ponerBarco(2);
		j.ponerBarco(2);
		j.ponerBarco(2);
		j.ponerBarco(2);
		//Tablero tablerotest = (Tablero) j.getTablerodefensa();
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
		j.ponerBarco(3);
		j.ponerBarco(3);
		j.ponerBarco(3);
		//tablerotest = (Tablero) j.getTablerodefensa();
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
		j.ponerBarco(4);
		j.ponerBarco(4);
		j.ponerBarco(4);
		//tablerotest = (Tablero) j.getTablerodefensa();
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
		j.ponerBarco(5);
		j.ponerBarco(5);
		j.ponerBarco(5);
		//tablerotest = (Tablero) j.getTablerodefensa();
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				assertEquals(j.getTablerodefensa().getTablero()[x][y], tablerodefensa5[x][y]);
			}
		}
		
	}

}
