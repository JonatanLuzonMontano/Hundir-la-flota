package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import hundirlaflota.Directa;

public class TestDirecta {

	@Test
	public void setCoordenada() throws IOException {
		ArrayList<String> coords = new ArrayList<String>();
		
		Directa d = new Directa(new MockTeclado(coords));
		
		//MAYUSCULAS
		//valores l�mite 'x' y 'y'
		
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
		
		
		
		//valores l�mite 'x' y partici�n equivalente 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 5);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 8);
		assertEquals(d.getCoordenadaY(), 0);
		
		//valores l�mite 'y' y partici�n equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 2);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 9);
		
		//partici�n equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 4);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 5);
		assertEquals(d.getCoordenadaY(), 7);
		
		//min�sculas
		//valores l�mite 'x' y 'y'
		
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
		
		
		
		//valores l�mite 'x' y partici�n equivalente 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 5);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 8);
		assertEquals(d.getCoordenadaY(), 0);
		
		//valores l�mite 'y' y partici�n equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 2);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 9);
		
		//partici�n equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 1);
		assertEquals(d.getCoordenadaY(), 4);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 5);
		assertEquals(d.getCoordenadaY(), 7);
		
		
	}

}
