package mx.unam.fes.problemas;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class EjercicioUno {

    public void generarArchivo() {
    	Random r = new Random();

        try {
        	PrintWriter archivo = new PrintWriter("numeros.txt");

            for (int i = 0; i < 10000; i++) {

                int numero = r.nextInt(300) + 1;
                archivo.print(numero + ",");
                
                if ((i + 1) % 1000 == 0) {
                    archivo.println();
                    
                }
            }

            archivo.close();
            System.out.println("Archivo creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}