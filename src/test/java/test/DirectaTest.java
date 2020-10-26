package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import hundirlaflota.Directa;

public class DirectaTest {

	@Test
	public void setCoordenada() throws IOException {
		ArrayList<String> coord = new ArrayList<String>();
		coord.add("A1");
		coord.add("A10");
		coord.add("J1");
		coord.add("J10");
		coord.add("Z1");
		coord.add("A11");
		coord.add("A-3");
		coord.add("P11");
		coord.add("N-3");
		coord.add("B6");
		coord.add("I6");
		coord.add("E2");
		coord.add("E9");
		coord.add("D5");
		coord.add("F8");
		
		coord.add("a1");
		coord.add("a10");
		coord.add("j1");
		coord.add("j10");
		coord.add("z1");
		coord.add("a11");
		coord.add("a-3");
		coord.add("p11");
		coord.add("n-3");
		coord.add("b6");
		coord.add("i6");
		coord.add("e2");
		coord.add("e9");
		coord.add("d5");
		coord.add("f8");
		
		Directa d = new Directa(new MockTeclado(coord));
		
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
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
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
		assertEquals(d.getCoordenadaY(), 5);
		
		//valores límite 'y' y partición equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 1);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 8);
		
		//partición equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 3);
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
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 0);
		assertEquals(d.getCoordenadaY(), -1);

		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
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
		assertEquals(d.getCoordenadaY(), 5);
		
		//valores límite 'y' y partición equivalente 'x'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 1);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 4);
		assertEquals(d.getCoordenadaY(), 8);
		
		//partición equivalente 'x' y 'y'
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 3);
		assertEquals(d.getCoordenadaY(), 4);
		
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), 5);
		assertEquals(d.getCoordenadaY(), 7);
		
		
	}

}
