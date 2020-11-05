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
				assertEquals(t.getTablero()[0][0], 0);
			}
		}
	}

}
