package mx.unam.fes.dinamico;

public class ListaDoblementeEnlazada {
	
	private NodoDoble cabeza, cola;
	private int longitud = 0;
	
	/**
	 * Inicializa la Lista Doble
	 */
	public ListaDoblementeEnlazada() {
	    cabeza = cola = null;
	}
	
	/**
	 * Comprueba si la lista está vacía.
	 * @return true si no contiene elementos, false en caso contrario
	 */
	public boolean esVacia() {
		return cabeza == null;
	}
	
	/**
	 * Agrega un nuevo nodo al inicio y actualiza sus referencias anterior y siguiente.
	 * @param dato
	 */
	public void agregarCabeza(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato, null, cabeza);

        if (cabeza != null) {
            cabeza.setAnterior(nuevo);
        } else {
            cola = nuevo;
        }

        cabeza = nuevo;
        longitud++;
    }
	
	/**
	 * Agrega un nuevo nodo al final y actualiza sus referencias anterior y siguiente.
	 * @param dato
	 */
	public void agregarCola(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato, cola, null);

        if (cola != null) {
            cola.setSiguiente(nuevo);
        } else {
            cabeza = nuevo;
        }

        cola = nuevo;
        longitud++;
    }
	
	/**
	 * Elimina y devuelve el primer elemento de la lista.
	 * @return
	 */
	public Object eliminarDeCabeza() {
        Object dato = null;

        if (!esVacia()) {
            dato = cabeza.getDato();

            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
            }

            longitud--;
        }

        return dato;
    }
	
	/**
	 * Elimina y devuelve el último elemento de la lista.
	 * @return
	 */
	public Object eliminarDeCola() {
        Object dato = null;

        if (!esVacia()) {
            dato = cola.getDato();

            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                cola = cola.getAnterior();
                cola.setSiguiente(null);
            }

            longitud--;
        }

        return dato;
    }
	
	/**
	 * Devuelve la cantidad de elementos de la lista.
	 * @return
	 */
	public int getLongitud() {
        return longitud;
    }
	
	/**
	 * Obtiene el dato almacenado en una posición determinada.
	 * @param indice
	 * @return
	 */
    public Object obtenerNodo(int indice) {
        NodoDoble temp = cabeza;

        for (int contador = 0;
             contador < indice && temp != null;
             contador++, temp = temp.getSiguiente());

        if (temp != null) {
            return temp.getDato();
        } else {
            return null;
        }
    }

    /**
     * Reemplaza el dato almacenado en una posición determinada.
     * @param dato
     * @param indice
     * @return
     */
    public boolean insertarEnIndice(Object dato, int indice) {
        NodoDoble temp = cabeza;

        for (int contador = 0;
             contador < indice && temp != null;
             contador++, temp = temp.getSiguiente());

        if (temp != null) {
            temp.setDato(dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Imprime los elementos de la lista desde la cabeza hasta la cola.
     */
    public void imprimir() {
        for (NodoDoble temp = cabeza;
             temp != null;
             temp = temp.getSiguiente()) {

            System.out.println(temp.getDato() + " ");
        }
    }

    /**
     * Busca y elimina la primera coincidencia del dato indicado.
     * @param dato
     */
    public void borrar(Object dato) {
        if (!esVacia()) {

            NodoDoble temp = cabeza;

            while (temp != null && !temp.getDato().equals(dato)) {
                temp = temp.getSiguiente();
            }

            if (temp != null) {

                if (temp == cabeza) {
                    eliminarDeCabeza();

                } else if (temp == cola) {
                    eliminarDeCola();

                    
                } else {
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp.getAnterior());
                    longitud--;
                }
            }
        }
    }

    /**
     * Elimina el elemento ubicado en una posición determinada.
     * @param indice
     */
    public void borrarEnIndice(int indice) {
        if (!esVacia()) {

            NodoDoble temp = cabeza;

            for (int contador = 0;
                 contador < indice && temp != null;
                 contador++, temp = temp.getSiguiente());

            if (temp != null) {

                if (temp == cabeza) {
                    eliminarDeCabeza();

                } else if (temp == cola) {
                    eliminarDeCola();

                } else {
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp.getAnterior());
                    longitud--;
                }
            }
        }
    }
	
	
	
}
