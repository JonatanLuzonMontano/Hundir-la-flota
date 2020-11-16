package hundirlaflota;

import java.io.IOException;

/***
 * Clase encargada de recibir y guardar todo lo que el usuario ha de introducir por teclado.
 * @author Jonat�n Luz�n Monta�o 1281175
 *
 */

public class Directa implements Coordenadas{

	private int x, y; //coordenadas
	
	public InterfazTeclado teclado; //Clase teclado por donde recibir� los datos

	private Integer direccion; //direcci�n hacia donde se pondr� el barco en el tablero
	
	private int indicelongitud; //longitud del barco que se pondr� en el tablero
	
	public Directa(InterfazTeclado teclado) {
		x = -1;
		y = -1;
		direccion = -1;
		indicelongitud = -1;
		this.teclado = teclado;
	}

	//m�todo para insertar la coordenada que deseamos. primero leemos el primer caracter de la cadena
	//y comprobamos que es una letra v�lida dentro de las coordenadas. depu�s leemos el resto de la cadena
	//y comprobamos que es un n�mero v�lido
	public void setCoordenada() throws IOException {
		// TODO Auto-generated method stub
		
		String coord = teclado.introducirDatos();
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
		
		//insertamos y (o n�mero de coordenada)
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

	//introducimos la direcci�n hacia la que queremos poner el barco
	public void setDireccion(Integer maximo) throws IOException {
		// TODO Auto-generated method stub
		try {
			int dir = Integer.parseInt(teclado.introducirDatos());
			if(dir >= 1 && dir <= maximo) {
				direccion = dir;
			} else {
				direccion = -1;
			}
		} catch (Exception e) {
			direccion = -1;
		}
	}
	
	//introducimos la posici�n dentro de la lista de posibles barcos a poner para saber cual pondremos a continuaci�n
	public void setLongitud(int maximo) throws IOException {
		// TODO Auto-generated method stub
		try {
			int lenght = Integer.parseInt(teclado.introducirDatos());
			if(lenght >= 1 && lenght <= maximo) {
				indicelongitud = lenght;
			} else {
				indicelongitud = -1;
			}
		} catch (Exception e) {
			direccion = -1;
		}
	}

	//getters
	
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

	public int getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}

	public int getLongitud() {
		// TODO Auto-generated method stub
		return indicelongitud;
	}	
}
