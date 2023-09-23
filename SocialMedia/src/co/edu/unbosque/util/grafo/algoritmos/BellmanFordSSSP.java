package co.edu.unbosque.util.grafo.algoritmos;

//Implementación java del algoritmo de BellmanFord
//para la busqueda del camino más corto de un vertice al
//resto y con capacidad de detección de ciclo negativo

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BellmanFordSSSP {

 static final int MAX = 105;
 static final int INF = 1 << 30;
 static int[] previo = new int[MAX];
 static int[] distancia = new int[MAX];
 static int vertices;
 static List<List<Node>> adyacencia = new ArrayList<List<Node>>();
 static Scanner sc = new Scanner(System.in);

 static void inicializacion() {
     for (int i = 0; i <= vertices; i++) {
         distancia[i] = INF;
         previo[i] = -1;
     }
 }

 static class Node {
     int first, second;
     public Node(int destino, int peso) {
         this.first = destino;
         this.second = peso;
     }
 }

 static void print(int destino) {
     if (previo[destino] != -1) {
         print(previo[destino]);
     }
     System.out.printf("%d ", destino);
 }

 static boolean relajacion(int actual, int adyacente, int peso) {
     if (distancia[actual] + peso < distancia[adyacente]) {
         distancia[adyacente] = distancia[actual] + peso;
         previo[adyacente] = actual;
         return true;
     }
     return false;
 }

 static void bellmanFord(int inicial) {
     inicializacion();
     distancia[inicial] = 0;
     for (int i = 0; i < vertices - 1; i++) {
         for (int actual = 0; actual < vertices; actual++) {
             for (int j = 0; j < adyacencia.get(actual).size(); j++) {
                 int adyacente = adyacencia.get(actual).get(j).first;
                 int peso = adyacencia.get(actual).get(j).second;
                 relajacion(actual, adyacente, peso);
             }
         }
     }
     for (int actual = 0; actual < vertices; actual++) {
         for (int j = 0; j < adyacencia.get(actual).size(); j++) {
             int adyacente = adyacencia.get(actual).get(j).first;
             int peso = adyacencia.get(actual).get(j).second;
             if (relajacion(actual, adyacente, peso)) {
                 System.out.println("Existe ciclo negativo");
                 return;
             }
         }
     }
     System.out.println("No existe ciclo negativo");
     System.out.printf("Distancias más corteas iniciando en el nodo %d\n", inicial);
     for (int i = 0; i < vertices; i++) {
         System.out.printf("Nodo %d , distancia más corta = %d\n", i, distancia[i]);
     }
     System.out.println("\n ________Camino más corto____");
     System.out.println("Ingrese vertice destino: ");
     int destino = sc.nextInt();
     print(destino);
     System.out.println("");
 }

 public static void main(String[] args) {
     int E, origen, destino, peso, inicial;
     vertices = sc.nextInt();
     E = sc.nextInt();
     for (int i = 0; i < vertices; i++) {
         adyacencia.add(new ArrayList<>());
     }
     for (int i = 0; i < E; i++) {
         origen = sc.nextInt();
         destino = sc.nextInt();
         peso = sc.nextInt();
         adyacencia.get(origen).add(new Node(destino, peso));
     }
     System.out.printf("Ingrese el nodo inicial: ");
     inicial = sc.nextInt();
     bellmanFord(inicial);
 }
}

