package co.edu.unbosque.util.grafo.algoritmos;

import co.edu.unbosque.util.grafo.generico.Edge;
import co.edu.unbosque.util.grafo.generico.Vertex;
import co.edu.unbosque.util.pilacola.QueueImpl;
import co.edu.unbosque.util.simple.MyLinkedList;

public class BreadthFirstSearch extends AbstractSearch {

	public BreadthFirstSearch(Vertex<?> sourceVertex, Vertex<?> destinationVertex) {
		super(sourceVertex, destinationVertex);

	}

	@Override
	public boolean runSearch() {
		
		if (this.sourceVertex.equals(destinationVertex)) {
			System.out.println("El objetivo fue encontrado");
			System.out.println(this.sourceVertex.getInfo());
		}
		
		QueueImpl<Vertex<?>> queueOfNodes = new QueueImpl<Vertex<?>>();
		MyLinkedList<Vertex<?>> visitedNodes = new MyLinkedList<Vertex<?>>();
		
		queueOfNodes.enqueue(this.sourceVertex);
		visitedNodes.addLast(sourceVertex);
		
		System.out.println("Ruta a seguir para ubicar el nodo");
		while (queueOfNodes.size() != 0) {
			Vertex<?> current = queueOfNodes.dequeue();
			if (current.equals(this.destinationVertex)) {
				System.out.println(current.getInfo());
				System.out.println("nodo buscado encontrado\n");
				return true;
			} else {
				System.out.print(current.getInfo() + " -> ");
				if (current.getAdyacentEdges().isEmpty()) {
					continue;
				} else {
					MyLinkedList<Edge> adyacents = current.getAdyacentEdges();
					while (!adyacents.isEmpty()) {
						queueOfNodes.enqueue(adyacents.extract().getDestination());
					}

				}
			}
			visitedNodes.addLast(current);

		}
		return false;

	}

}
