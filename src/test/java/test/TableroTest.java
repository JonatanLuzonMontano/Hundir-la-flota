package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import hundirlaflota.Tablero;

class TableroTest {

	@Test
	void contructor() {
		Tablero t = new Tablero();
		for(int i = 0; i < 10; i++) {
			for ( int j = 0; j < 10; j++) {
				assertEquals(t.getTablero()[i][j], 0);
			}
		}
	}
	
	@Test
	void setCasilla() {
		Tablero t = new Tablero();
		
		t.setCasilla(5, 5, -5);
		assertEquals(t.getTablero()[5][5], 0);
		t.setCasilla(5, 5, -1);
		assertEquals(t.getTablero()[5][5], 0);
		t.setCasilla(5, 5, 1);
		assertEquals(t.getTablero()[5][5], 1);
		t.setCasilla(5, 5, 0);
		assertEquals(t.getTablero()[5][5], 0);
		t.setCasilla(5, 5, 2);
		assertEquals(t.getTablero()[5][5], 2);
		t.setCasilla(5, 5, 3);
		assertEquals(t.getTablero()[5][5], 2);
		t.setCasilla(5, 5, 7);
		assertEquals(t.getTablero()[5][5], 2);
	}

}
