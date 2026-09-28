package mx.unam.fes.inicio;

import mx.unam.fes.estatico.ArregloAlonso;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Principal_Uno {
	public static void main(String[] args) {
		ArregloAlonso<Integer> arrUno=new ArregloAlonso<Integer>(3);
		try {
			while(!arrUno.vacio()) {
				arrUno.insertar(34);
				
			}
			arrUno.imprimir();
		
			
			
		} catch (IndicieFueraExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
