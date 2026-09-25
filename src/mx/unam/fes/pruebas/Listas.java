package mx.unam.fes.pruebas;
import java.util.LinkedList;

public class Listas<T> {
	
	private LinkedList<T> lista;
    private T ultimoInsertado;
    private T ultimoEliminado;

    public Listas() {
        this.lista = new LinkedList<>();
        this.ultimoInsertado = null;
        this.ultimoEliminado = null;
    }

    public void imprimir() {
        System.out.print("Contenido de la lista: [ ");
        lista.forEach(elemento -> System.out.print(elemento + " "));
        System.out.println("]");
    }

    public void insertar(T elemento, int posicion) {
        if (posicion >= 0 && posicion <= lista.size()) {
            lista.add(posicion, elemento);
            ultimoInsertado = elemento;
        } else {
            System.out.println("Error: La posición está fuera de rango.");
        }
    }

    public T recuperar(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    public T recuperarUltimoInsertado() {
        return ultimoInsertado;
    }

    public T borrar(int indice) {
        if (indice >= 0 && indice < lista.size()) {

            ultimoEliminado = lista.remove(indice); 
            return ultimoEliminado;
        }
        return null;
    }

    public void borrar(int indiceInicial, int indiceFinal) {
        if (indiceInicial >= 0 && indiceFinal < lista.size() && indiceInicial <= indiceFinal) {

            lista.subList(indiceInicial, indiceFinal + 1).clear();
        } else {
            System.out.println("Error: Rango de borrado inválido.");
        }
    }

    public T recuperarUltimoEliminado() {
        return ultimoEliminado;
    }

    public int obtenerIndice(T elemento) {

        return lista.indexOf(elemento); 
    }

    public void limpiar() {
        lista.clear();
        ultimoInsertado = null;
        ultimoEliminado = null;
    }
}
