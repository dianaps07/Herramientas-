package mx.unam.fes.problemas;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import mx.unam.fes.dinamico.*;

public class EjercicioDos {
	
	public void leerArchivo() {
		
		ListaSimple lista=new ListaSimple();
		
		try {
			Scanner lector=new Scanner(new File("numeros.txt"));
			lector.useDelimiter("[,\\s]+");
			
			while (lector.hasNextInt()) {
				int numero=lector.nextInt();
				if (numero >= 30 && numero <= 150) {
					lista.agregarCola(numero);
				}
				
			}
			
			lector.close();
			
			int[] frecuencia=new int[151];
			
			for (int i = 0; i < lista.getLongitud(); i++) {
	            int numero = (Integer) lista.obtenerNodo(i);
	            frecuencia[numero]++;
	        }

	        for (int i = 30; i <= 150; i++) {
	            System.out.println(i + " - salió " + frecuencia[i] + " veces");
	        }
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
