package mx.unam.fes.inicio;

import java.util.Random;

import mx.unam.fes.dinamicas.Lista;
import mx.unam.fes.dinamicas.Nodo;

public class EjercicioDos {
	public static void main(String[] args) {
		
		Lista<Integer>listaUno=new Lista<>();
		Lista<Integer> listaDos=new Lista<>();
		Random random=new Random();
		

		for(int i=0;i<10000;i++) {
			int numAleatorio=random.nextInt(300)+1;
			
			listaUno.agregarCabeza(numAleatorio);
	}
		/**
		 * Rango que cuenta para el rango de 30 a 150
		 */
		int []repite=new int [151];
		/**
		 * Filtra y cuenta las repeticiones
		 */
		Nodo<Integer> actual=listaUno.obtenerNodo(0);
		
		while(actual!=null) {
			int numero=(int)actual.getDato();
		
		
		/**
		 * Verifica que el numero este entre 30 y 150
		 */
		if(numero>=30 && numero<=150) {
			listaDos.agregarCabeza(numero);
			repite[numero]++;
			
		}
		actual=actual.getSiguiente();
		}
		
	
	/**
	 * Cuenta las frecuencias, cuantas veces se repite cada numero que sale
	 */
		
	for(int i=30;i<=150;i++) {
		if(repite[i]>0) {
			System.out.println("El numero: "+ i+ " salio: " +  repite[i] +  "veces");
		}else {
			System.out.println("El numero" + i+ "no se repitio ninguna vez");
		}
	}

}
}
