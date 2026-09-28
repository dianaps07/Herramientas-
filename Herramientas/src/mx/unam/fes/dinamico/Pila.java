package mx.unam.fes.dinamico;

public class Pila {

    private Nodo cabeza;
    private int longitud = 0;

    /**
     * Inicializa la pila.
     */
    public Pila() {
        cabeza = null;
    }

    /**
     * Comprueba si la pila no tiene elementos.
     * @return
     */
    public boolean esVacia() {
        return cabeza == null;
    }

    /**
     * Agrega un elemento en la cima de la pila.
     * @param dato
     */
    public void insertar(Object dato) {
        cabeza = new Nodo(dato, cabeza);
        longitud++;
    }

    /**
     * Elimina y devuelve el elemento que se encuentra en la cima.
     * @return
     */
    public Object eliminar() {
        Object dato = null;

        if (!esVacia()) {
            dato = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            longitud--;
        }

        return dato;
    }

    /**
     * Devuelve el elemento que se encuentra en la cima sin eliminarlo.
     * @return
     */
    public Object cima() {
        if (!esVacia()) {
            return cabeza.getDato();
        } else {
            return null;
        }
    }

    /**
     * Devuelve el número de elementos que contiene la pila.
     * @return
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Recorre e imprime los elementos de la pila.
     */
    public void imprimir() {
        for (Nodo temp = cabeza;
             temp != null;
             temp = temp.getSiguiente()) {

            System.out.println(temp.getDato() + " ");
        }
    }
}