package Hundir.la.Flota;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestCoordenadaDirecta {

	@Test
	public void test() throws IOException {
		Directa d = new Directa(new MockTeclado("Coordenadas.txt"));
		
		//valores límite 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'a');
		assertEquals(d.getCoordenadaY(), 1);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'a');
		assertEquals(d.getCoordenadaY(), 10);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'j');
		assertEquals(d.getCoordenadaY(), 1);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'j');
		assertEquals(d.getCoordenadaY(), 10);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), null);
		assertEquals(d.getCoordenadaY(), 1);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), null);
		assertEquals(d.getCoordenadaY(), 1);
		

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'a');
		assertEquals(d.getCoordenadaY(), null);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'a');
		assertEquals(d.getCoordenadaY(), null);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), null);
		assertEquals(d.getCoordenadaY(), null);
		
		
		
		//valores límite 'x' y partición equivalente 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'b');
		assertEquals(d.getCoordenadaY(), 5);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'i');
		assertEquals(d.getCoordenadaY(), 1);
		
		//valores límite 'y' y partición equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'e');
		assertEquals(d.getCoordenadaY(), 2);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'e');
		assertEquals(d.getCoordenadaY(), 9);
		
		//partición equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'b');
		assertEquals(d.getCoordenadaY(), 4);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 'f');
		assertEquals(d.getCoordenadaY(), 7);
		
		
	}

}
