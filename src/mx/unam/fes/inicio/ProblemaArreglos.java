package mx.unam.fes.inicio;
import java.util.Random;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndiceFueraExeption;

public class ProblemaArreglos {
	public static void main(String[] args) {
		try {
			//1000 numeros aleatorios entre 0 y 100
			int tope=1000;
			Arreglo<Integer>numeros=new Arreglo<>(tope);
			Random random=new Random();
			
			for(int i=0;i<tope;i++) {
				numeros.insertar(random.nextInt(101));
		}
			//Mayor y segundo mayor con Promedio
			int primerMayor=Integer.MIN_VALUE;
			int segundoMayor=Integer.MIN_VALUE;
			double suma=0;
			
			
			for(int i=0;i<numeros.getIndice();i++) {
				int num=numeros.recuperar(i);
				
				if(num>primerMayor) {
					primerMayor=num;
				}else if(num>segundoMayor && num!=primerMayor) {
					segundoMayor=num;
				}
			}
			double promedio=(double)suma/numeros.getIndice();
			System.out.println("PROBLEMAS 1 Y 2");
			System.out.println("Numero mayor: " +primerMayor);
			System.out.println("Segundo mayor: " +segundoMayor);
			System.out.println("Promedio: " +promedio);
			
			//Cuantas veces se repite un numero
			Arreglo<Integer>listaEjercicio=new Arreglo<>(10);
			int []valores= {45,23,54,34,45,11,34,56,11};
			for(int num:valores) {
				listaEjercicio.insertar(num);	
			}
			
			Arreglo<Integer>contados=new Arreglo<>(listaEjercicio.getIndice());
			for(int i=0;i<listaEjercicio.getIndice();i++) {
				int v=listaEjercicio.recuperar(i);
				
				if(contados.localiza(v)==-1) {
					int contador=0;
					
					for(int j=0;j<listaEjercicio.getIndice();j++) {
						if(listaEjercicio.recuperar(j)==v) {
							contador++;
						}
					}
					System.out.println(v+"="+contador);
					contados.insertar(v);
				}
			}
			
				
			} catch (IndiceFueraExeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
		
			
			
			
			
	}

}}
