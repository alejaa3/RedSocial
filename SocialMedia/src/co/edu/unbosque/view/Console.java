package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {
	
	private Scanner sc;
	
	
	public Console() {
		sc = new Scanner(System.in);
	}
	public int readInt() {
		int n = sc.nextInt();
		return n;
	}
	
	public String read() {
		String n = sc.nextLine();
		return n;
	}
	
	
	public void print(String txt) {
		System.out.println(txt);
	}

}
