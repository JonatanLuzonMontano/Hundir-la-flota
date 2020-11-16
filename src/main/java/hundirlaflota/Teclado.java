package hundirlaflota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Clase encargada de leer por los datos que envia el usuario por teclado
 * @author Jonat�n Luz�n Monta�o 1281175
 *
 */

public class Teclado implements InterfazTeclado {
	
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(entrada);
	
	//funci�n que espera a que el usuario introduzca los datos por teclado
	public String introducirDatos() throws IOException {
		
		return buffer.readLine();
	}
}
