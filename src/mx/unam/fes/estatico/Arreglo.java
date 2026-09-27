package mx.unam.fes.estatico;
import java.util.Arrays;
import java.util.stream.IntStream;

import mx.unam.fes.exepciones.IndiceFueraExeption;

public class Arreglo<E> {
	private int indice;
	private final Object[] arreglo;
	public Arreglo(int longitud) {
		arreglo=new Object[longitud];
		indice=0;
		
	}
	//INSERTA
	/**
	 * Inserta el nuevo elemento en una posiscion disponible
	 * @param elemento
	 * @throws IndiceFueraExeption
	 */
	
	public void insertar(E elemento) throws IndiceFueraExeption {
		if(indice<arreglo.length) {
			arreglo[indice]=elemento;	
			indice++;
		}else {
			 throw new IndiceFueraExeption("Indice fuera del arreglo");
		}
	}
	//LOCALIZA
	/**
	 * Localiza, devuelve la posicion(indice) del elemento x, si no existe retorna -1
	 * @param x
	 * @return
	 */
	
	public int localiza(E x) {
		for(int i=0;i<indice;i++) {
			if(arreglo[i]!=null &&arreglo[i].equals(x)) {
				return i;
			}
		}
		return -1; //No lo encuentra
	}
	

	//RECUPERAR
	/**
	 * Muestra un elemento en una posiscion especifica 
	 * @param pos
	 * @return
	 */
	public E recuperar(int pos) {
		if(pos>=0 && pos<arreglo.length) {
			return(E)arreglo[pos];
		}
		return null;
	}
	/**
	 * Recupera el ultimo elemento ingresado
	 * @return
	 */
	public E recuperarUltimo() {
		if(this.indice>0) {
			return(E)arreglo[this.indice-1];
		}
		return null;
		
	}
	
	
	
	//BORRAR/SUPRIME
	/**
	 * Borra un elemento en una posicion elegida
	 * @param p
	 * @return
	 */
	public boolean borrarElegido(int p) {
		if(p>=0 && p<arreglo.length) {
			arreglo[p]=null;
			return true;
		}
		return false;
	}
	/**
	 * Borra un rango de elementos
	 * @param inicio
	 * @param fin
	 * @return
	 */
	
	public boolean borrarRango(int inicio, int fin) {
		if(inicio>=0 && fin< arreglo.length && inicio<=fin) {
			IntStream.rangeClosed(inicio, fin).forEach(i->arreglo[i]=null);
			return true;
		 
	}return false;	

}
	
	//SIGUIENTE
	/**
	 * Devuelve el valor siguiente de la posicion p
	 * @param p
	 * @return
	 * @throws IndiceFueraExeption
	 */
	public E siguiente(int p)throws IndiceFueraExeption{
		if(p<0 ||p>=indice-1) {
			throw new IndiceFueraExeption("No existe un elemento en la siguiente posiscion"+p);
		}
		return (E)arreglo[p+1];
	}
	
	//ANTERIOR
	/**
	 * Devuelve el valor anterior a la posicion p
	 * @param p
	 * @return
	 */
	public E anterior(int p)throws IndiceFueraExeption{
		if(p<=0 ||p>=indice) {
			throw new IndiceFueraExeption("No existe un elemento anterior para la posiscion"+p);
			
		}
		return (E)arreglo[p-1];
		
	}
	
	//LIMPIAR
	/**
	 * Limpia el arreglo
	 */
	public void limpiar() {
		for(int i=0;i<indice;i++) {
			arreglo[i]=null;
		}
		indice=0;
	}
	
	//PRIMERO
	/**
	 * Devuelve el primer elemento del arreglo
	 * @return
	 * @throws IndiceFueraExeption
	 */
	public E primero() throws IndiceFueraExeption{
		if(vacio()) {
			throw new IndiceFueraExeption("El arreglo esta vacio");
			
		}
		return (E) arreglo[0];
	}
	
	
	
	
	/**
	 * Verifica si el arreglo no tiene elementos añadidos
	 * @return
	 */
	public boolean vacio() {
		if (indice < arreglo.length) {
			return false; 
		}
		return true; 
	}
	//IMPRIMIR
	/**
	 * Imprime los elementos del arreglo
	 */
	public void imprimir() {
		for(int i=0;i<arreglo.length;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	//ASIGNAR
	/**
	 * Asigna un valor x en la posicion p
	 * @param p
	 * @param x
	 * @throws IndiceFueraExeption
	 */
	public void asignar (int p,E x) throws IndiceFueraExeption{
		if(p<0||p>=indice) {
			throw new IndiceFueraExeption("Posicion invalida");
			
		}
		arreglo[p]=x;
	}
	
	//GET
	public int getIndice() {
		return this.indice;
	}
	

	


	

}