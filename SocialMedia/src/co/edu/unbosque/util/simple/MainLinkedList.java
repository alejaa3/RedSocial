package co.edu.unbosque.util.simple;

public class MainLinkedList {
	public static void main(String[] args) {

		MyLinkedList<Student> linkedlist = new MyLinkedList<>();

		linkedlist.addLast(new Student("diego", 11));
		linkedlist.addLast(new Student("diego", 12));
		linkedlist.addLast(new Student("diego", 13));
		linkedlist.addLast(new Student("diego", 14));
		linkedlist.addLast(new Student("diego", 15));
		linkedlist.add(new Student("diego", 16));

		System.out.println(linkedlist.print());
	}
}
