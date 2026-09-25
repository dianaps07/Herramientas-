package mx.unam.fes.pruebas;
import java.util.Random;

public class Inicio {
	public static void main(String[] args) {
		/**
		 * Generar un arreglo de 1000 elementos 
		 */
		Integer[] a = new Integer[1000];
		Random r = new Random();
		//Se recorre el arreglo para asignar un numero aleatorio
		for(int i = 0; i<a.length; i++) {
			a[i] = r.nextInt(101)+50;
		}
		// Variables 
		int pares = 0;
		int impares = 0;
		int suma = 0;
		int multiplos10 =0;
		//Calculos
		for(int i = 0; i < a.length; i++) {
			//Verificar si el número es par
			if(a[i] % 2==0) {
				pares++;
			}else {
				//Si no es par, el número es impar
				impares++;
			}
			//Verificar si el número es multiplo de 10 
			if (a[i] % 10==0) {
				multiplos10++;
			}
			//Suma de todos los elementos del arreglo
			suma = suma + a[i];
		}
		//Calcula el promedio de todos los elemento 
		double promedio =(double)suma/a.length;
		
		//Imprimir
		System.out.println("Cantidad de pares: " + pares);
		System.out.println("Cantidad de impares: " + impares);
		System.out.println("Cantidad de multiplos: " + multiplos10);
		System.out.println("Promedio general: " + promedio);
		
	}
	
}
