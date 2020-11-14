package test;

import java.util.ArrayList;

import hundirlaflota.Barco;
import hundirlaflota.InterfazTablero;
import hundirlaflota.InterfazTeclado;
import hundirlaflota.Jugador;

public class MockJugador extends Jugador{

	public MockJugador(InterfazTeclado teclado) {
		super(teclado);
		// TODO Auto-generated constructor stub
	}
	
	public boolean[] getDirecciones() {
		return direcciones;
	}
	
	public void setDirecciones(boolean[] newdirecciones) {
		direcciones = newdirecciones;
	}
	
	public void setBarcoPuestos(ArrayList<Barco> listabarcos) {
		this.barcospuestos = listabarcos;
	}

	public void setBarcoSinPoner(ArrayList<Barco> listabarcos) {
		this.barcossinponer = listabarcos;
	}

	public void setTablerodefensa(InterfazTablero tablerodefensa) {
		this.tablerodefensa = tablerodefensa;
	}

	public void setTableroataque(InterfazTablero tableroataque) {
		this.tableroataque = tableroataque;
	}

}
