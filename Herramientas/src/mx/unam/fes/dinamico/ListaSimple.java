package mx.unam.fes.dinamico;

public class ListaSimple {

	private Nodo cabeza, cola;
	private int longitud = 0;

	/**
	 * Inicializa la Lista Simple
	 */
	public ListaSimple() {
		cabeza = cola = null;
	}

	/**
	 * Comprueba si la lista no contiene elementos.
	 * @return
	 */
	public boolean esVacia() {
		return cabeza == null;
	}

	/**
	 * Agrega un nuevo nodo al inicio de la lista.
	 * @param dato
	 */
	public void agregarCabeza(Object dato) {
		cabeza = new Nodo(dato, cabeza);

		if (cola == null) {
			cola = cabeza;
		}

		longitud++;
	}

	/**
	 * Agrega un nuevo nodo al final de la lista.
	 * @param dato
	 */
	public void agregarCola(Object dato) {
		if (!esVacia()) {
			cola.setSiguiente(new Nodo(dato));
			cola = cola.getSiguiente();
		} else {
			cola = cabeza = new Nodo(dato);
		}

		longitud++;
	}

	/**
	 * Elimina el primer nodo y devuelve el dato que contenía.
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
			}

			longitud--;
		}

		return dato;
	}

	/**
	 * Elimina el últimos nodo y devuelve el dato que contenía.
	 * @return
	 */
	public Object eliminarDeCola() {
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
	 * Devuelve el número actual de elementos de la lista.
	 * @return
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * Busca un nodo mediante su índice y devuelve el dato almacenado
	 * @param indice
	 * @return
	 */
	public Object obtenerNodo(int indice) {
		Nodo temp = cabeza;

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
	 * Cambia el dato almacenado en el nodo ubicado en el índice indicado.
	 * @param dato
	 * @param indice
	 * @return
	 */
	public boolean insertarEnIndice(Object dato, int indice) {
		Nodo temp = cabeza;

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
	 * Recorre la lista desde la cabeza hasta la cola e imprime sus elementos.
	 */
	public void imprimir() {
		for (Nodo temp = cabeza;
			 temp != null;
			 temp = temp.getSiguiente()) {

			System.out.println(temp.getDato() + " ");
		}
	}

	/**
	 * Busca un dato y elimina el primer nodo que lo contiene
	 * @param dato
	 */
	public void borrar(Object dato) {
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
					 predesor = predesor.getSiguiente(),
					 tmp = tmp.getSiguiente());

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

	/**
	 * Busca un nodo mediante su índice y lo elimina de la lista.
	 * @param indice
	 */
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
					 predesor = predesor.getSiguiente(),
					 tmp = tmp.getSiguiente(),
					 contador++);

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
