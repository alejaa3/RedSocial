package co.edu.unbosque.util.pilacola;

public interface Queue<E> {

	public void enqueue(E info);

	public E dequeue();

	int size();
}