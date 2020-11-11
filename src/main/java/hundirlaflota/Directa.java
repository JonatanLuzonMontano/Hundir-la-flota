package hundirlaflota;

import java.io.IOException;

public class Directa implements Coordenadas{

	private int x, y;
	
	public InterfazTeclado teclado;

	private Integer direccion;
	
	public Directa(InterfazTeclado teclado) {
		x = -1;
		y = -1;
		direccion = -1;
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
	public void setCoordenada() throws IOException {
		// TODO Auto-generated method stub
		
		String coord = teclado.introducirCoordenada();
		try {
			//insertamos x (o letra de la coordenada)
			if(((short) coord.charAt(0))>=65 && ((short)coord.charAt(0)<=74)) {
				x = (short) coord.charAt(0) - 65;
			} else {
				if(((short) coord.charAt(0))>=97 && ((short)coord.charAt(0)<=106)) {
					x = (short) coord.charAt(0) - 97;
				} else {
					x = -1;
				}
			}
		}catch(Exception e){
			x=-1;
		}
		
		//insertamos y (o número de coordenada)
		try{
			String coordy = coord.substring(1);
			int cy = Integer.parseInt(coordy);
			
			if(cy>=1 && cy<=10) {
				y = cy-1;
			} else {
				y=-1;
			}
		}catch(Exception e){
			y=-1;
		}
	}

	public void setDireccion() throws IOException {
		// TODO Auto-generated method stub
		int dir = Integer.parseInt(teclado.introducirCoordenada());
		if(dir >= 1 && dir <= 4) {
			direccion = dir;
		} else {
			direccion = -1;
		}
	}

	public int getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}	
}
