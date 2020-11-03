package hundirlaflota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado implements InterfazTeclado {
	
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(entrada);
	
	public String introducirCoordenada() throws IOException {
		
		return buffer.readLine();
	}
}
