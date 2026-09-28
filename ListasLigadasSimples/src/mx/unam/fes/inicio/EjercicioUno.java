package mx.unam.fes.inicio;

import java.util.Random;

import mx.unam.fes.dinamicas.Lista;
import mx.unam.fes.dinamicas.Nodo;

public class EjercicioUno {
	public static void main(String[] args) {
		Lista <Integer>lista=new Lista<>();
		Random random=new Random();
		
		
		for(int i=0;i<10000;i++) {
			int numAleatorio=random.nextInt(300)+1;
			
			lista.agregarCabeza(numAleatorio);
		}
		System.out.println(" Generando 10000 numeros aleatorios entre 1-300: ");
		/**
		 * Obtiene el primer nodo(posicion 0)
		 */

		Nodo <Integer >actual=lista.obtenerNodo(0);
		int contador=1;
		while(actual!=null){
			/**
			 * Imprime el dato del nodo actual con un espacio
			 */
			System.out.print(actual.getDato() + " , ");
			
			/**
			 * Cada 1000 elementos imprime un salto de linea 
			 */
			if(contador%1000==0) {
				System.out.println();
			}
			/**
			 * Avanza al siguiente nodo 
			 */
			actual=actual.getSiguiente();
			contador++;
			
		}
	}

}
