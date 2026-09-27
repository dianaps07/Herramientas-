package mx.unam.fes.inicio;

import java.util.Random;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndiceFueraExeption;

public class Principal_Uno {
	public static void main(String[] args) {
		Arreglo<Integer> arrUno=new Arreglo<Integer>(3);
		Arreglo<String> arrDos=new Arreglo<String>(10);
		try {
			Random random=new Random();
			while(!arrUno.vacio()) {
				int n =random.nextInt(100)+1;
				if (n%2 !=0) {
					arrUno.insertar(n);
				}
			}
			System.out.println("Arreglo");
			arrUno.imprimir();
			
			
			
		} catch (IndiceFueraExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
