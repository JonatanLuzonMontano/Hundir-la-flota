package Hundir.la.Flota;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MockTeclado implements Teclado{
	
	FileInputStream file;
	BufferedReader br;
	String line;
	String[] linefetchet;
	ArrayList<String> inputs = new ArrayList<String>();
	
	public MockTeclado (String file) throws IOException {
		this.file = new FileInputStream(file);
		br = new BufferedReader (new InputStreamReader(this.file));
		while((line = br.readLine()) != null) {
			linefetchet = line.split(" ");
			for(String each : linefetchet) {
				inputs.add(each);
			}
		}
	}
	
	public String introducirCoordenada() {
		return inputs.remove(0);
	}
}
