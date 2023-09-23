package co.edu.unbosque.view;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Console {
	
	private Scanner sc;
	
	
	public Console() {
		sc = new Scanner(System.in);
	}
	public int readInt() {
		while (true) {
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			try {
				throw new InvalidNumberException();
			} catch (InvalidNumberException ex) {
				System.out.println(ex.getMessage());
				burnLine();
				continue;

			}
		}
		}
	}

	public void burnLine() {
		sc.nextLine();
	}
	
	public String read() {
		String n = sc.nextLine();
		return n;
	}
	
	
	public void print(String txt) {
		System.out.println(txt);
	}

}
