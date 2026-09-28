package mx.unam.fes.dinamico;

public class NodoDoble {
	
	private Object dato;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(Object dato) {
        this(dato, null, null);
    }

    public NodoDoble(Object dato, NodoDoble anterior, NodoDoble siguiente) {
        this.dato = dato;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}

