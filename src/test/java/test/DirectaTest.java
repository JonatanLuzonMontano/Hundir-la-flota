package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import hundirlaflota.Directa;


/**
 * Test de la clase Directa
 * @author Jonatán Luzón Montaño
 *
 */
public class DirectaTest {

	//valores límite, frontera y partición equivalente
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
		coord.add("AA");
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
		coord.add("aa");
		coord.add("b6");
		coord.add("i6");
		coord.add("e2");
		coord.add("e9");
		coord.add("d5");
		coord.add("f8");
		coord.add("?¿");
		
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

		d.setCoordenada();		
		assertEquals(d.getCoordenadaX(), 0);
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
		
		d.setCoordenada();		
		assertEquals(d.getCoordenadaX(), 0);
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
		
		//simbolos ajenos a las coordenadas
		d.setCoordenada();
		assertEquals(d.getCoordenadaX(), -1);
		assertEquals(d.getCoordenadaY(), -1);
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	public void setDireccion() throws IOException { 
		
		ArrayList<String> dir1 = new ArrayList<String>();
		dir1.add("-3");
		dir1.add("-1");
		dir1.add("0");
		dir1.add("1");
		dir1.add("2");
		dir1.add("3");
		dir1.add("4");
		dir1.add("5");
		dir1.add("8");
		dir1.add("a");
		dir1.add("A");
		dir1.add("¿");
		dir1.add("!");
		dir1.add("hola");
		
		Directa d = new Directa(new MockTeclado(dir1));
		
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), 1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), 2);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), 3);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), 4);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
		d.setDireccion(4);
		assertEquals(d.getDireccion(), -1);
	}
	
	//valores límite, frontera y partición equivalente
	@Test
	public void setLongitud() throws IOException { 
		ArrayList<String> longitud = new ArrayList<String>();
		
		longitud.add("-3");
		longitud.add("-1");
		longitud.add("0");
		longitud.add("1");
		longitud.add("2");
		longitud.add("4");
		longitud.add("a");
		longitud.add("A");
		longitud.add("¿");
		longitud.add("!");
		longitud.add("hola");
		
		Directa d = new Directa(new MockTeclado(longitud));
		
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), 1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(1);
		assertEquals(d.getLongitud(), -1);

		longitud.add("-1");
		longitud.add("0");
		longitud.add("1");
		longitud.add("2");
		longitud.add("3");
		longitud.add("4");

		d.setLongitud(2);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(2);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(2);
		assertEquals(d.getLongitud(), 1);
		d.setLongitud(2);
		assertEquals(d.getLongitud(), 2);
		d.setLongitud(2);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(2);
		assertEquals(d.getLongitud(), -1);
		
		longitud.add("-1");
		longitud.add("0");
		longitud.add("1");
		longitud.add("2");
		longitud.add("3");
		longitud.add("4");
		longitud.add("5");

		d.setLongitud(3);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(3);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(3);
		assertEquals(d.getLongitud(), 1);
		d.setLongitud(3);
		assertEquals(d.getLongitud(), 2);
		d.setLongitud(3);
		assertEquals(d.getLongitud(), 3);
		d.setLongitud(3);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(3);
		assertEquals(d.getLongitud(), -1);
		
		longitud.add("-1");
		longitud.add("0");
		longitud.add("1");
		longitud.add("2");
		longitud.add("3");
		longitud.add("4");
		longitud.add("5");
		longitud.add("6");
		
		d.setLongitud(4);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), 1);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), 2);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), 3);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), 4);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), -1);
		d.setLongitud(4);
		assertEquals(d.getLongitud(), -1);
		
	}

}
