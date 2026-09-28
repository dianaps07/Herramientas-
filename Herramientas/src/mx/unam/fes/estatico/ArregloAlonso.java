package mx.unam.fes.estatico;

import mx.unam.fes.exepciones.IndicieFueraExeption;

public class ArregloAlonso<E> {
	
	private int indice;
	private final Object[] arreglo;
	
	/**
	 * Inicializa un nuevo arreglo
	 * @param longitud
	 */
	public ArregloAlonso(int longitud) {
		arreglo=new Object[longitud];
	}
	
	/**
	 * Método para insertar valores dentro del arreglo.
	 * @param elemento
	 * @throws IndicieFueraExeption
	 */
	public void insertar(E elemento) throws IndicieFueraExeption {
		if(indice<arreglo.length) {
			arreglo[indice]=elemento;	
			indice++;
		}else {
			 throw new IndicieFueraExeption("Indice fuera del arreglo");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean vacio() {
		if (indice < arreglo.length) {
			return false; 
		}
		return true; 
	}
	
	/**
	 * Este método nos ayuda a imprimir el contenido del arreglo.
	 * Considerar que si i<arreglo.length;, y únicamente insertamos 3 valores, nuestra lista se verá:
	 * "10,20,30,null,null,null,null,null,null,null,", sería mejor que el criterio fuera i<indice.
	 */
	public void imprimir() {
		//for(int i=0;i<arreglo.length;i++) {
		for(int i=0;i<indice;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	//NUEVOS MÉTODOS//
	
	/**
	 * Limpiar nos ayuda a eliminar elementos de nuestro arreglo.
	 * Recorre el arreglo usando el indice, mientras esto se cumpla para cada elemento en la posición i se asigna un null.
	 * Cuando termina, vuelve a indice a su valor inicial, o sea, indice=0;.
	 */
	public void limpiar() {
		for(int i=0;i<indice;i++) {
			arreglo[i]=null;
		}
		
		indice=0;
	}
	
	/**
	 * Este método es más complejo, inserta un valor de tipo E en la posición que deseemos.
	 * Para esto, tenemos que considerar algunos aspectos
	 * Primero si el arreglo está lleno.
	 * Si aún hay espacio, lo siguiente es que la posición sea válida:
	 * 	-> Una de las condiciones para esto es que no existen posiciones <0, entonces números negativos no son válidos.
	 * 	-> La segunda condición no es obligatoria en un sentido absoluto, pero la conservamos para mantener una continuidad.
	 * Luego de esto desplazamos los elementos para abrir un espacio en la posición que queremos.
	 * Ahora simplemente se agrega el elemento E en la posición que liberamos.
	 * Finalmente actualizamos indice.
	 * @param elemento
	 * @param posicion
	 * @throws IndicieFueraExeption
	 */
	public void insertar(E elemento,int posicion) throws IndicieFueraExeption {
		if (indice>=arreglo.length) {
		    throw new IndicieFueraExeption("El arreglo está lleno");
		}
		
		if (posicion<0 || posicion>indice) {
		    throw new IndicieFueraExeption("Posición inválida");
		}
		
		for (int i=indice;i>posicion;i--) {
		    arreglo[i]=arreglo[i-1];
		}
		
		arreglo[posicion] = elemento;
		indice++;
	}
	
	/**
	 * Este método nos pide la posición del elemento, y nos regresa un valor de tipo E.
	 * Usamos las mismas condiciones que en insertar:
	 * -> Si la posición es <0 o en la posición no hay ningun valor, entonces la posición no es válida.
	 * @param posicion
	 * @return
	 * @throws IndicieFueraExeption
	 */
	@SuppressWarnings("unchecked")
	public E recuperar(int posicion) throws IndicieFueraExeption {
		
		if (posicion<0 || posicion>=indice) {
	        throw new IndicieFueraExeption("Posición inválida");
	    }
		return (E) arreglo[posicion];
	}
	
}
