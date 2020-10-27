package hundirlaflota;

public class Directa implements Coordenadas{

	private int x, y;
	
	public Teclado teclado;
	
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
		
		String coord = teclado.introducirCoordenada();
		int xy = (short) coord.charAt(0);
		
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
		
		//insertamos y (o número de coordenada)
		
		String coordy = coord.substring(1);
		int cy = Integer.parseInt(coordy);
		
		if(cy>=1 && cy<=10) {
			y = cy-1;
		} else {
			y=-1;
		}
		
	}

}
