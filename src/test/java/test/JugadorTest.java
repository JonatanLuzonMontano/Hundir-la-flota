package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import hundirlaflota.InterfazJugador;
import hundirlaflota.Jugador;
import hundirlaflota.Tablero;
import hundirlaflota.Teclado;

class JugadorTest {
	
	@Test
	void comprovarDirección() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		//Barco lognitud 2
		coord.add("a1");
		coord.add("a10");
		coord.add("j1");
		coord.add("j10");
		coord.add("b2");
		coord.add("b9");
		coord.add("i2");
		coord.add("i9");
		coord.add("e5");
		
		//Barco lognitud 3
		coord.add("b2");
		coord.add("b9");
		coord.add("i2");
		coord.add("i9");
		coord.add("c3");
		coord.add("c8");
		coord.add("h3");
		coord.add("h8");
		coord.add("e5");
		
		//Barco longitud 4
		coord.add("c3");
		coord.add("c8");
		coord.add("h3");
		coord.add("h8");
		coord.add("d4");
		coord.add("d7");
		coord.add("g4");
		coord.add("g7");
		coord.add("e5");
		
		//Barco longitud 5
		coord.add("d4");
		coord.add("d7");
		coord.add("g4");
		coord.add("g7");
		coord.add("e5");
		coord.add("e6");
		coord.add("f5");
		coord.add("f6");
		Jugador j = new Jugador(new MockTeclado(coord));

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
		j.comprovarDireccion(2, 0, 0);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//b9
		j.comprovarDireccion(2, 0, 9);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//i2
		j.comprovarDireccion(2, 9, 0);
		assertTrue(j.getDirecciones()[0]);
		assertTrue(j.getDirecciones()[1]);
		assertTrue(j.getDirecciones()[2]);
		assertTrue(j.getDirecciones()[3]);
		//i9
		j.comprovarDireccion(2, 9, 9);
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
	void comprovarObstaculos() {
		
	}

	@Test
	void disparar() {
		
	}
	
	@Test
	void ponerBarco() {
		
	}

}
