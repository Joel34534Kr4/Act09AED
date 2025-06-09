package ListLinked;

public class ListLinked<T> {
    private Node<T> first;
    private int count;

    public ListLinked() {
        first = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public void add(T data) {
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

    public T get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        Node<T> aux = first;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public int search(T data) {
        Node<T> aux = first;
        int pos = 0;
        while (aux != null) {
            if (aux.data.equals(data)) return pos;
            aux = aux.next;
            pos++;
        }
        return -1; // No encontrado
    }

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

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
