package graph;

public class Edge<E> {
    private Vertex<E> refDest;
    private int weight;

    public Edge(Vertex<E> refDest) {
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

    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.refDest.equals(e.refDest); // Compara solo el destino de la arista
        }
        return false;
    }

    public String toString() {
        return refDest.getData() + (this.weight > -1 ? " [" + this.weight + "]" : "") + ", ";
    }
}
