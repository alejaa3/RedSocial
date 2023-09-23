package co.edu.unbosque.util.grafo.algoritmos;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PrimMST {

  public static void main(String[] args) {
      int V = 9;
      Graph graph = new Graph(V);
      addEdge(graph, 0, 1, 4);
      addEdge(graph, 0, 7, 8);
      addEdge(graph, 1, 2, 8);
      addEdge(graph, 1, 7, 11);
      addEdge(graph, 2, 3, 7);
      addEdge(graph, 2, 8, 2);
      addEdge(graph, 2, 5, 4);
      addEdge(graph, 3, 4, 9);
      addEdge(graph, 3, 5, 14);
      addEdge(graph, 4, 5, 10);
      addEdge(graph, 5, 6, 2);
      addEdge(graph, 6, 7, 1);
      addEdge(graph, 6, 8, 6);
      addEdge(graph, 7, 8, 7);
      prims_mst(graph);
  }

  static class node1 {
      int dest;
      int weight;
      node1(int a, int b) {
          dest = a;
          weight = b;
      }
  }

  static class Graph {
      int V;
      LinkedList<node1>[] adj;
      Graph(int e) {
          V = e;
          adj = new LinkedList[V];
          for (int o = 0; o < V; o++) {
              adj[o] = new LinkedList<>();
          }
      }
  }

  static class node {
      int vertex;
      int key;
  }


  static class comparator implements Comparator<node> {

      @Override
      public int compare(node node0, node node1) {
          return node0.key - node1.key;
      }
  }
  static void addEdge(Graph graph, int src, int dest, int weight) {
      node1 node0 = new node1(dest, weight);
      node1 node = new node1(src, weight);
      graph.adj[src].addLast(node0);
      graph.adj[dest].addLast(node);
  }

  // Buscar MST
  static void prims_mst(Graph graph) {
      Boolean[] mstset = new Boolean[graph.V];
      node[] e = new node[graph.V];
      int[] parent = new int[graph.V];
      for (int o = 0; o < graph.V; o++) {
          e[o] = new node();
      }
      for (int o = 0; o < graph.V; o++) {
          //inicializar en falso
          mstset[o] = false;
          // Inicial valores key en infinito
          e[o].key = Integer.MAX_VALUE;
          e[o].vertex = o;
          parent[o] = -1;
      }
      // incluir el vertice inicial en el MST
      mstset[0] = true;
      e[0].key = 0;
      PriorityQueue<node> queue = new PriorityQueue<>(graph.V, new comparator());
      for (int o = 0; o < graph.V; o++) {
          queue.add(e[o]);
      }
      while (!queue.isEmpty()) {
          node node0 = queue.poll();
          mstset[node0.vertex] = true;
          for (node1 iterator : graph.adj[node0.vertex]) {
              if (mstset[iterator.dest] == false) {
                  if (e[iterator.dest].key > iterator.weight) {
                      queue.remove(e[iterator.dest]);
                      e[iterator.dest].key = iterator.weight;
                      queue.add(e[iterator.dest]);
                      parent[iterator.dest] = node0.vertex;
                  }
              }
          }
      }
      // Imprimir el par de vertices del mst 
      for (int o = 1; o < graph.V; o++) {
          System.out.println(parent[o] + " "
                  + "-"
                  + " " + o);
      }
  }
}


