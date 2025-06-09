package graph;
package graph;
import ListLinked.ListLinked;
// clase generica que representa un vertice en el grafo
public class Vertex<E> {
    private E data; // dato almacenado en el vertice
    protected ListLinked<Edge<E>> listAdj; //listas de aristas adyacentes
    public Vertex(E data) { //metodo constructor que inicializa el vertice con un dato y una lista vacia de aristas
        this.data = data;
        listAdj = new ListLinked<>();
    }

    public E getData() { //un getter para obtener el dato del vertice
        return data;
    }
    //Método equals que compara dos vértices basándose en el dato.
    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }
    //Representación en cadena del vértice y sus aristas adyacentes.
    public String toString() {
        return this.data + " --> " + this.listAdj.toString() + "\n";
    }
}

    public String toString() {
        return this.data + " --> " + this.listAdj.toString() + "\n";
    }
}
