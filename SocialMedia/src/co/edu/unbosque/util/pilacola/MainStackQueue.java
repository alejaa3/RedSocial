package co.edu.unbosque.util.pilacola;

public class MainStackQueue {

	public static void main(String[] args) {
		QueueImpl<Integer> queue = new QueueImpl<>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		System.out.println("Printing queue: " + queue.toString());

		int s = queue.size();
		System.out.println("Printing size: " + s);

		int o = queue.dequeue();
		System.out.println("Deque element = " + o);

		System.out.println("Printing queue: " + queue.toString());
		
		///////////
		System.out.println();
		///////////

		StackImpl<Integer> stack = new StackImpl<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println("Printing stack: " + stack.toString());

		int s2 = stack.size();
		System.out.println("Printing size: " + s2);

		int o2 = stack.pop();
		System.out.println("Pop element = " + o2);

		System.out.println("Printing stack: " + stack.toString());

	}

}
