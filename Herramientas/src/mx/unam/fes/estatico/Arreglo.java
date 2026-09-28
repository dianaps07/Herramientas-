package mx.unam.fes.estatico;
import java.util.stream.IntStream;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Arreglo<E>{
	
	private int indice;
	private final Object[] arreglo;
	
	/**
	 * Inicializa el arreglo.
	 * @param longitud
	 */
	public Arreglo(int longitud) {
		
		arreglo=new Object[longitud];
		indice=0;
	}

	/**
	 * Inserta el nuevo elemento en una posición disponible.
	 * @param elemento
	 * @throws IndicieFueraExeption
	 */
	public void insertar(E elemento) throws IndicieFueraExeption {
		
		if(indice<arreglo.length) {
			arreglo[indice]=elemento;	
			indice++;
			
		} else {
			 throw new IndicieFueraExeption("Indice fuera del arreglo");
		}
	}
	
	 /**
	  * Devuelve la posición(índice) del elemento x, si no existe retorna -1.
	  * @param x
	  * @return
	  */
	public int localiza(E x) {
		
		for(int i=0;i<indice;i++) {
			
			if(arreglo[i]!=null && arreglo[i].equals(x)) {
				return i;
			}
		}
		return -1; //No lo encuentra
	}
	
	/**
	 * Muestra un elemento en una posición específica.
	 * @param pos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E recuperar(int pos) {
		
		if(pos>=0 && pos<arreglo.length) {
			
			return(E)arreglo[pos];
		}
		return null;
	}
	
	/**
	 * Recupera el último elemento ingresado.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E recuperarUltimo() {
		
		if(this.indice>0) {
			
			return(E)arreglo[this.indice-1];
		}
		return null;
		
	}
	
	/**
	 * Borra un elemento en una posición elegida.
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
	 * Borra un rango de elementos.
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public boolean borrarRango(int inicio, int fin) {
		if(inicio>=0 && fin< arreglo.length && inicio<=fin) {
			
			IntStream.rangeClosed(inicio, fin).forEach(i->arreglo[i]=null);
			return true;
		}
		return false;

	}
	
	/**
	 * Devuelve el valor siguiente de la posición p.
	 * @param p
	 * @return
	 * @throws IndicieFueraExeption
	 */
	@SuppressWarnings("unchecked")
	public E siguiente(int p)throws IndicieFueraExeption{
		if(p<0 ||p>=indice-1) {
			
			throw new IndicieFueraExeption("No existe un elemento en la siguiente posiscion"+p);
		}
		return (E)arreglo[p+1];
	}
	
	/**
	 * Limpia el arreglo.
	 */
	public void limpiar() {
		for(int i=0;i<indice;i++) {
			
			arreglo[i]=null;
		}
		indice=0;
	}
	
	/**
	 * Devuelve el primer elemento del arreglo.
	 * @return
	 * @throws IndicieFueraExeption
	 */
	@SuppressWarnings("unchecked")
	public E primero() throws IndicieFueraExeption{
		if(vacio()) {
			
			throw new IndicieFueraExeption("El arreglo esta vacio");
		}
		return (E) arreglo[0];
	}
	
	/**
	 * Verifica si el arreglo no tiene elementos añadidos.
	 * @return
	 */
	public boolean vacio() {
		if (indice < arreglo.length) {
			
			return false; 
		}
		return true; 
	}
	
	/**
	 * Imprime los elementos del arreglo-
	 */
	public void imprimir() {
		for(int i=0;i<arreglo.length;i++) {
			
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	/**
	 * Asigna un valor x en la posicion p.
	 * @param p
	 * @param x
	 * @throws IndicieFueraExeption
	 */
	public void asignar (int p,E x) throws IndicieFueraExeption{
		if(p<0||p>=indice) {
			
			throw new IndicieFueraExeption("Posicion invalida");
		}
		arreglo[p]=x;
	}
	
	/**
	 * Regresa el valor de índice.
	 * @return
	 */
	public int getIndice() {
		
		return this.indice;
	}
	
}
