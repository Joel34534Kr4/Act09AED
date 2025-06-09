package ListLinked;
//Implementación simple de una lista enlazada genérica.
public class ListLinked<T> {
    private Node<T> first; // Nodo inicial de la lista
    private int count; // Número de elementos en la lista

    public ListLinked() { //Constructor que inicializa la lista vacía.
        first = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null; //Verifica si la lista está vacía.
    }

    public int size() {
        return count; //Retorna el tamaño (cantidad de elementos) de la lista.
    }

    public void add(T data) {//metodo que añade un nuevo elemento al final de la lista
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> aux = first;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        count++;
    }
    //obtiene el elemento en la posición dada.
    public T get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        Node<T> aux = first;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public int search(T data) { //Busca el índice de un elemento en la lista.
        Node<T> aux = first;
        int pos = 0;
        while (aux != null) {
            if (aux.data.equals(data)) return pos;
            aux = aux.next;
            pos++;
        }
        return -1; // No encontrado
    }
    // Elimina un elemento en una posición específica
    public boolean remove(int index) {
        if (index < 0 || index >= count) return false;

        if (index == 0) {
            first = first.next;
        } else {
            Node<T> aux = first;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }
            aux.next = aux.next.next;
        }
        count--;
        return true;
    }
    // Representación textual de los elementos de la lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> aux = first;
        while (aux != null) {
            sb.append(aux.data.toString());
            aux = aux.next;
        }
        return sb.toString();
    }
    // Clase interna que representa un nodo en la lista
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
