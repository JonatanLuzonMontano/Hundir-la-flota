package Hundir.la.Flota;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestCoordenadaDirecta {

	@Test
	public void setCoordenada() throws IOException {
		Directa d = new Directa(new MockTeclado("Coordenadas.txt"));
		
		//MAYUSCULAS
		//valores límite 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), 0);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), 9);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 9);
		assertEquals(d.getCoordenadaY(), 0);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 9);
		assertEquals(d.getCoordenadaY(), 9);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), 0);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), 0);
		

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), -1);
		
		
		
		//valores límite 'x' y partición equivalente 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 5);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 8);
		assertEquals(d.getCoordenadaY(), 0);
		
		//valores límite 'y' y partición equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 2);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 9);
		
		//partición equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 4);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 5);
		assertEquals(d.getCoordenadaY(), 7);
		
		//minúsculas
		//valores límite 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), 0);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), 9);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 9);
		assertEquals(d.getCoordenadaY(), 0);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 9);
		assertEquals(d.getCoordenadaY(), 9);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), 0);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), 0);
		

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), -1);
		
		
		
		//valores límite 'x' y partición equivalente 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 5);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 8);
		assertEquals(d.getCoordenadaY(), 0);
		
		//valores límite 'y' y partición equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 2);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 9);
		
		//partición equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 4);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 5);
		assertEquals(d.getCoordenadaY(), 7);
		
		
	}

}
