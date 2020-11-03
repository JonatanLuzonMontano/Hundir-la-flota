package test;

import java.io.IOException;
import java.util.ArrayList;

import hundirlaflota.InterfazTeclado;

public class MockTeclado implements InterfazTeclado{
	
	public ArrayList<String> inputs = new ArrayList<String>();
	
	public MockTeclado (ArrayList<String> coord) throws IOException {
		this.inputs = coord;
	}
	
	public String introducirCoordenada() {
		return inputs.remove(0);
	}
}
