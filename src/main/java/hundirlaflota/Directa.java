package hundirlaflota;

import java.io.IOException;

/***
 * Clase encargada de recibir y guardar todo lo que el usuario ha de introducir por teclado.
 * @author Jonatán Luzón Montaño 1281175
 *
 */

public class Directa implements Coordenadas{

	private int x, y; //coordenadas
	
	public InterfazTeclado teclado; //Clase teclado por donde recibirá los datos

	private Integer direccion; //dirección hacia donde se pondrá el barco en el tablero
	
	private int indicelongitud; //longitud del barco que se pondrá en el tablero
	
	public Directa(InterfazTeclado teclado) {
		x = -1;
		y = -1;
		direccion = -1;
		indicelongitud = -1;
		this.teclado = teclado;
	}

	//método para insertar la coordenada que deseamos. primero leemos el primer caracter de la cadena
	//y comprobamos que es una letra válida dentro de las coordenadas. depués leemos el resto de la cadena
	//y comprobamos que es un número válido
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

	//introducimos la dirección hacia la que queremos poner el barco
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
	
	//introducimos la posición dentro de la lista de posibles barcos a poner para saber cual pondremos a continuación
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
