package main;
import java.util.Scanner;
import graph.*;
import ListLinked.*;
public class main {

    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        // Opciones del menú
        String[] opciones = {
                "Insertar vértice",
                "Insertar arista (sin peso)",
                "Insertar arista ponderada",
                "Eliminar vértice",
                "Eliminar arista",
                "Buscar vértice",
                "Buscar arista",
                "Recorrido en profundidad (DFS)",
                "Recorrido en anchura (BFS)",
                "Mostrar todo el grafo",
                "Salir"
        };

        do {
            // Menú de opciones
            System.out.println("------MENU DE OPCIONES------");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }

            System.out.println("Seleccione una opción: ");
            opcion = entrada.nextInt(); // Para ingresar la opción

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato del vértice: ");
                    String vertexData = entrada.next();
                    if (graph.insertVertex(vertexData)) {
                        System.out.println("Vértice insertado.");
                    } else {
                        System.out.println("El vértice ya existe.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el vértice de origen: ");
                    String origin = entrada.next();
                    System.out.print("Ingrese el vértice de destino: ");
                    String destination = entrada.next();
                    if (graph.insertEdge(origin, destination)) {
                        System.out.println("Arista insertada (sin peso).");
                    } else {
                        System.out.println("Error al insertar la arista o los vértices no existen.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el vértice de origen: ");
                    String originWeight = entrada.next();
                    System.out.print("Ingrese el vértice de destino: ");
                    String destinationWeight = entrada.next();
                    System.out.print("Ingrese el peso de la arista: ");
                    int weight = entrada.nextInt();
                    if (graph.insertEdgeWeight(originWeight, destinationWeight, weight)) {
                        System.out.println("Arista insertada con peso.");
                    } else {
                        System.out.println("Error al insertar la arista ponderada o los vértices no existen.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el vértice a eliminar: ");
                    String vertexToRemove = entrada.next();
                    if (graph.removeVertex(vertexToRemove)) {
                        System.out.println("Vértice eliminado.");
                    } else {
                        System.out.println("El vértice no existe.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el vértice de origen: ");
                    String removeOrigin = entrada.next();
                    System.out.print("Ingrese el vértice de destino: ");
                    String removeDestination = entrada.next();
                    if (graph.removeEdge(removeOrigin, removeDestination)) {
                        System.out.println("Arista eliminada.");
                    } else {
                        System.out.println("Error al eliminar la arista.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el vértice a buscar: ");
                    String searchVertex = entrada.next();
                    Vertex<String> foundVertex = graph.searchVertex(searchVertex);
                    if (foundVertex != null) {
                        System.out.println("Vértice encontrado: " + foundVertex.getData());
                    } else {
                        System.out.println("Vértice no encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el vértice de origen: ");
                    String originSearch = entrada.next();
                    System.out.print("Ingrese el vértice de destino: ");
                    String destinationSearch = entrada.next();
                    if (graph.searchEdge(originSearch, destinationSearch)) {
                        System.out.println("La arista existe.");
                    } else {
                        System.out.println("La arista no existe.");
                    }
                    break;

                case 8:
                    System.out.print("Ingrese el vértice de inicio para DFS: ");
                    String dfsStart = entrada.next();
                    graph.dfs(dfsStart);
                    break;

                case 9:
                    System.out.print("Ingrese el vértice de inicio para BFS: ");
                    String bfsStart = entrada.next();
                    graph.bfs(bfsStart);
                    break;

                case 10:
                    System.out.println("Representación del grafo:");
                    graph.printGraph();
                    break;

                case 11:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 11); // Se repite hasta seleccionar la opción 11 (salir)

        entrada.close(); // Se cierra el scanner
    }
}
