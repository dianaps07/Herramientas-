package mx.unam.fes.dinamico;

public class Cola {
	
    private Nodo cabeza, cola;
    private int longitud = 0;

    /**
     * Inicializa la cola.
     */
    public Cola() {
        cabeza = cola = null;
    }
    
    /**
     * Comprueba si la cola no contiene elementos.
     * @return
     */
    public boolean esVacia() {
        return cabeza == null;
    }
    
    /**
     * Agrega un elemento en la cima de la cola.
     * @param dato
     */
    public void insertar(Object dato) {
        cabeza = new Nodo(dato, cabeza);

        if (cola == null) {
            cola = cabeza;
        }

        longitud++;
    }

    /**
     * Elimina y devuelve el elemento que se encuentra en la cola.
     * @return
     */
    public Object eliminar() {
        Object dato = null;

        if (!esVacia()) {
            dato = cola.getDato();

            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                Nodo temp;

                for (temp = cabeza;
                     temp.getSiguiente() != cola;
                     temp = temp.getSiguiente());

                cola = temp;
                cola.setSiguiente(null);
            }

            longitud--;
        }

        return dato;
    }

    /**
     * Devuelve el elemento que está próximo a salir sin eliminarlo.
     * @return
     */
    public Object frente() {
        if (!esVacia()) {
            return cola.getDato();
        } else {
            return null;
        }
    }

    /**
     * Devuelve el número de elementos que contiene la cola.
     * @return
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Recorre e imprime los elementos de la cola.
     */
    public void imprimir() {
        for (Nodo temp = cabeza;
             temp != null;
             temp = temp.getSiguiente()) {

            System.out.println(temp.getDato() + " ");
        }
    }
}


