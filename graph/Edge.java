package graph;
//Clase generica que representa un arista del grafo
public class Edge<E> {
    private Vertex<E> refDest; //referencia al vertice destino de la arista
    private int weight; // ésp de la arista -1 indica que no tiene peso asignado

    public Edge(Vertex<E> refDest) { // metodo constructor de arista con peso
        this(refDest, -1); // Peso por defecto -1 (sin peso)
    }

    public Edge(Vertex<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    // Getter para refDest
    public Vertex<E> getRefDest() {
        return refDest;
    }
    // metodo para comparar si dos aristas son iguales
    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.refDest.equals(e.refDest); // Compara solo el destino de la arista
        }
        return false;
    }
    //metodo que devuelve la representación en cadena de la arista, mostrando el dato del vertice
    //destino y el peso si es mayor a -1
    public String toString() {
        return refDest.getData() + (this.weight > -1 ? " [" + this.weight + "]" : "") + ", ";
    }
}
