package hundirlaflota;

import java.io.IOException;

public class CoordenadaBarco implements Coordenadas {
	int x, y;
	
	CoordenadaBarco(int x, int y){
		this.x = x;
		this.y = y;
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

	}

}
