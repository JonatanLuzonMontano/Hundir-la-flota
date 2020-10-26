package test;

import java.io.IOException;
import java.util.ArrayList;

import hundirlaflota.Teclado;

public class MockTeclado implements Teclado{
	
	public ArrayList<String> inputs = new ArrayList<String>();
	
	public MockTeclado (ArrayList<String> coord) throws IOException {
		this.inputs = coord;
	}
	
	public String introducirCoordenada() {
		return inputs.remove(0);
	}
}
