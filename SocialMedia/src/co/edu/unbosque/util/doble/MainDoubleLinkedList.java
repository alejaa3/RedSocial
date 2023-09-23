package co.edu.unbosque.util.doble;

public class MainDoubleLinkedList {

	
	public static void main(String[] args) {
		MyDoubleLinkedList<String> list = new MyDoubleLinkedList<>();
		
		list.insert("Node1");
		list.insert("Node2");
		
		System.out.println("List: " + list.toString());
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		list.insert("Node3");
		
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		System.out.println("List: " + list.toString());
		list.back(1);
		
		System.out.println("Go back one position");
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		System.out.println("List: " + list.toString());
		list.insert("Node4");
		
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		System.out.println("List: " + list.toString());
		list.extract();
		
		System.out.println("delete... ");
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		System.out.println("List: " + list.toString());
		System.out.println("Go forward 7 ");
		list.forward(7);
		
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		System.out.println("List: " + list.toString());
		list.back(1);
		list.extract();
		
		System.out.println("Current position: " + list.getCurrentPosition().getInfo());
		System.out.println("List: " + list.toString());
		list.extract();
		
		System.out.println("Current position: " + list.getCurrentPosition());
		System.out.println("List: " + list.toString());
		list.forward(1);
		list.extract();
		
		System.out.println("Current position: " + list.getCurrentPosition());
		System.out.println("List: " + list.toString());
		list.extract();
		
		System.out.println("Current position: " + list.getCurrentPosition());
		System.out.println("List: " + list.toString());
		
		///////////////////////////////////////////////////////////////////
		
		MyDequeList<Integer> deque = new MyDequeList<>();
		deque.insertFirst(9);
		deque.insertFirst(7);
		deque.insertFirst(6);
		deque.insertFirst(4);
		deque.insertFirst(8);
		deque.insertLast(8);
		deque.insertLast(8);
		System.out.println(deque.toString());
		
		
		
		/////////////////////////////////////
		
		
		
		
	}
}
