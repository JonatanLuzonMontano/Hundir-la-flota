package Hundir.la.Flota;

import java.util.ArrayList;

public class Directa implements Coordenadas{

	private int x, y;
	
	Teclado teclado;
	
	public Directa(Teclado teclado) {
		x = -1;
		y = -1;
		this.teclado = teclado;
	}

	@Override
	public int getCoordenadaX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	@Override
	public int getCoordenadaY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setCoordenada() {
		// TODO Auto-generated method stub
		
	}

}
