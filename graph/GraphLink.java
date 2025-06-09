package graph;

import java.util.*;

import ListLinked.ListLinked;

public class GraphLink<E> {
    private ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    // Agrega un vértice si no existe
    public boolean insertVertex(E data) {
        if (searchVertex(data) != null) return false;
        listVertex.add(new Vertex<>(data));
        return true;
    }

    // Busca y retorna el vértice con dato E
    public Vertex<E> searchVertex(E data) {
        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            if (v.getData().equals(data)) return v;
        }
        return null;
    }

    // Agrega una arista no dirigida sin peso
    public boolean insertEdge(E origin, E destination) {
        Vertex<E> vOrig = searchVertex(origin);
        Vertex<E> vDest = searchVertex(destination);
        if (vOrig == null || vDest == null) return false;

        // Validar si ya existe la arista
        if (vOrig.listAdj.search(new Edge<>(vDest)) != -1) return false;

        vOrig.listAdj.add(new Edge<>(vDest));
        vDest.listAdj.add(new Edge<>(vOrig));
        return true;
    }

    // Agrega una arista ponderada no dirigida
    public boolean insertEdgeWeight(E origin, E destination, int weight) {
        Vertex<E> vOrig = searchVertex(origin);
        Vertex<E> vDest = searchVertex(destination);
        if (vOrig == null || vDest == null) return false;

        // Validar si ya existe la arista
        if (vOrig.listAdj.search(new Edge<>(vDest)) != -1) return false;

        vOrig.listAdj.add(new Edge<>(vDest, weight));
        vDest.listAdj.add(new Edge<>(vOrig, weight));
        return true;
    }

    // Verifica si existe una arista entre dos vértices
    public boolean searchEdge(E origin, E destination) {
        Vertex<E> vOrig = searchVertex(origin);
        Vertex<E> vDest = searchVertex(destination);
        return vOrig != null && vDest != null && vOrig.listAdj.search(new Edge<>(vDest)) != -1;
    }

    // Elimina una arista entre dos vértices
    public boolean removeEdge(E origin, E destination) {
        Vertex<E> vOrig = searchVertex(origin);
        Vertex<E> vDest = searchVertex(destination);
        if (vOrig == null || vDest == null) return false;

        int indexOrig = vOrig.listAdj.search(new Edge<>(vDest));
        int indexDest = vDest.listAdj.search(new Edge<>(vOrig));
        if (indexOrig != -1) vOrig.listAdj.remove(indexOrig);
        if (indexDest != -1) vDest.listAdj.remove(indexDest);
        return true;
    }

    // Elimina un vértice y sus aristas
    public boolean removeVertex(E data) {
        Vertex<E> v = searchVertex(data);
        if (v == null) return false;

        // Eliminar referencias desde otros vértices
        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> current = listVertex.get(i);
            int index = current.listAdj.search(new Edge<>(v));
            if (index != -1) current.listAdj.remove(index);
        }

        // Eliminar el vértice
        listVertex.remove(listVertex.search(v));
        return true;
    }
 // Recorrido en profundidad (DFS)
    public void dfs(E start) {
        Vertex<E> vStart = searchVertex(start);
        if (vStart == null) return;

        Set<Vertex<E>> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsVisit(vStart, visited);
        System.out.println();
    }

    private void dfsVisit(Vertex<E> v, Set<Vertex<E>> visited) {
        if (visited.contains(v)) return;

        // Procesamos el vértice
        System.out.print(v.getData() + " ");
        visited.add(v);

        // Recorrer la lista de adyacencia manualmente con get()
        for (int i = 0; i < v.listAdj.size(); i++) {
            Edge<E> edge = v.listAdj.get(i);
            Vertex<E> neighbor = edge.getRefDest(); // Usamos el getter
            if (!visited.contains(neighbor)) {
                dfsVisit(neighbor, visited);
            }
        }
    }

 // Recorrido en anchura (BFS)
    public void bfs(E start) {
        Vertex<E> vStart = searchVertex(start);
        if (vStart == null) return;

        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        visited.add(vStart);
        queue.add(vStart);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            // Recorrer la lista de adyacencia manualmente con get()
            for (int i = 0; i < current.listAdj.size(); i++) {
                Edge<E> edge = current.listAdj.get(i);
                Vertex<E> neighbor = edge.getRefDest(); // Usamos el getter
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }


    // Mostrar todo el grafo
    public void printGraph() {
        for (int i = 0; i < listVertex.size(); i++) {
            System.out.print(listVertex.get(i).toString());
        }
    }
}
