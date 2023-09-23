package co.edu.unbosque.util.grafo.algoritmos;

public class HamiltonianCycleDetector {

    static final int V = 5;
    static int path[];

    /* Una función de utilidad para comprobar si el vértice v puede ser
       añadido en el índice 'pos'en el ciclo hamiltoniano
       construido hasta ahora (almacenado en 'path[]')*/
    static boolean isSafe(int v, int graph[][], int path[], int pos) {
        /*Verifica si este vertice es adyacente del 
        anterior vertice */
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }
        /* Verifica si el vertice ya esta incluido*/
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }

    static boolean hamCycleUtil(int graph[][], int path[], int pos) {
        /* Caso base:Si todos los vertices estan incluidos en  
           el ciclo hamiltoniano*/
        if (pos == V) {
            // Y si hay un camino de el ultimo al primer vertice
            return graph[path[pos - 1]][path[0]] == 1;
        }
        /*Prueba diferentes vértices como próximo candidato
        en el ciclo hamiltoniano. No intentamos con 0, 
        ya que incluimos 0 como punto de partida en hamCycle ()*/
        for (int v = 1; v < V; v++) {
            /* Verifica si este vertice puede ser añadido al
            ciclo hamiltoniano*/
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                /* Recorre hasta construir el camino*/
                if (hamCycleUtil(graph, path, pos + 1) == true) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        /* Si no hay vertice para añadir al ciclo
        retorna falso*/
        return false;
    }

    /* Esta función resuelve el problema del ciclo hamiltoniano usando
       backtracking. Utiliza principalmente hamCycleUtil () para resolver el
       problema. Devuelve falso si no hay ciclo hamiltoniano.
       posible, de lo contrario devuelve verdadero e imprime la ruta.
       Tenga en cuenta que puede haber más de una solución,
       Esta función imprime una de las soluciones factibles.*/
    static int hamCycle(int graph[][]) {
        path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
        /* Pongamos el vértice 0 como el primer vértice en el camino.
           Si hay un ciclo hamiltoniano, entonces el camino puede ser
           Comenzó desde cualquier punto del ciclo ya que la gráfica es
           no dirigido*/
        path[0] = 0;
        if (hamCycleUtil(graph, path, 1) == false) {
            System.out.println("\nNo existe solución");
            return 0;
        }
        printSolution(path);
        return 1;
    }

    // Imprimir solución
    static void printSolution(int path[]) {
        System.out.println("Solución existe: Este"
                + " es uno de los ciclos hamiltoniano");
        for (int i = 0; i < V; i++) {
            System.out.print(" " + path[i] + " ");
        }
        System.out.println(" " + path[0] + " ");
    }

    public static void main(String args[]) {
        /*Tenemos el siguiente grafo 
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 1},
        {0, 1, 1, 1, 0},};
        // Imprimir solución
        hamCycle(graph1);
        /*Tenemos el siguiente grafo 
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0},};
        // Imprimir solución
        hamCycle(graph2);
    }
}
