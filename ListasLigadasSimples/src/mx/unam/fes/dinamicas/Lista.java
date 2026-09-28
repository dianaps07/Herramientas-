package mx.unam.fes.dinamicas;

public class Lista <E> {
	private Nodo <E>cabeza,cola;
	private int longitud=0;
	
	public Lista() {
		cabeza=cola=null;
	}
	public boolean esVacia() {
		return cabeza==null;
		
	}
	
	public void agregarCabeza(E dato) {
		cabeza=new Nodo(dato,cabeza);
		if(cola==null) {
			cola=cabeza;
		}
		longitud++;
	}
	
	public void agregarCola(E dato) {
		if(!esVacia()) {
			cola.setSiguiente(new Nodo(dato));
			cola=cola.getSiguiente();
		}else {
			cola=cabeza=new Nodo(dato);
		}
		longitud++;
	}
	
	public E eliminarDeCabeza() {
		E dato=null;
		if(!esVacia()) {
			dato=cabeza.getDato();
			if(cabeza==cola) {
				cabeza=cola=null;
			}else {
				cabeza=cabeza.getSiguiente();
			}
			longitud--;
		}
		return dato;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public E eliminarDeCola() {
		E dato=null;
		if(!esVacia()) {
			dato=cola.getDato();
			if(cabeza==cola) {
				cabeza=cola=null;
			}else {
				Nodo temp;
				for(temp=cabeza;temp.getSiguiente()!=cola;temp=temp.getSiguiente());
				cola=temp;
				cola.setSiguiente(null);
			}
			longitud--;
		}
		return dato;
	}
	
	public Nodo <E>obtenerNodo(int indice) {
		Nodo temp = cabeza;
		for (int contador = 0; contador < indice && temp != null;
		contador++, temp = temp.getSiguiente());
		if (temp != null) {
		return temp;
		} else {
		return null;
		}
	}
	
	public boolean insertarEnIndice(E dato, int indice) {
		Nodo temp = cabeza;
		for (int contador = 0; contador < indice && temp != null;
		contador++, temp = temp.getSiguiente());
		if (temp != null) {
		temp.setDato(dato);
		return true;
		} else {
		return false;
		}
	}
	
	public void imprimir() {
		for (Nodo temp = cabeza; temp != null; temp = temp.getSiguiente()) {
		System.out.println(temp.getDato() + " ");
		}
	}
	
	public void borrar(E dato) {
		if (!esVacia()) {
		if (cabeza == cola && dato.equals(cabeza.getDato())) {
		cabeza = cola = null;
		longitud--;
		} else if (dato.equals(cabeza.getDato())) {
		cabeza = cabeza.getSiguiente();
		longitud--;
		} else {
		Nodo predesor, tmp;
		for (predesor = cabeza, tmp = cabeza.getSiguiente();
		tmp != null && !tmp.getDato().equals(dato);
		predesor = predesor.getSiguiente(), tmp = tmp.getSiguiente());
		if (tmp != null) {
		predesor.setSiguiente(tmp.getSiguiente());
		if (tmp == cola) {
		cola = predesor;
		}
		longitud--;
		}
		}
		}
		}
	
	public void borrarEnIndice(int indice) {
		if (!esVacia()) {
		if (cabeza == cola && indice == 0) {
		cabeza = cola = null;
		longitud--;
		} else if (indice == 0) {
		cabeza = cabeza.getSiguiente();
		longitud--;
		} else {
		Nodo predesor, tmp;
		int contador = 1;
		for (predesor = cabeza, tmp = cabeza.getSiguiente();
		contador < indice;

		predesor = predesor.getSiguiente(), tmp = tmp.getSiguiente(), contador++);

		if (tmp != null) {
		predesor.setSiguiente(tmp.getSiguiente());
		if (tmp == cola) {
		cola = predesor;
		}
		longitud--;
		}
	}
}
	
	

}
	}
