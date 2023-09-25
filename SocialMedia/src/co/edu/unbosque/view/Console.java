package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.Texto;
import co.edu.unbosque.util.exceptions.InvalidNumberException;

public class Console {
	
	private Scanner sc;
	
	
	public Console() {
		sc = new Scanner(System.in);
	}
	
	public void next() {
		sc.nextLine();
	}
	
	public int readInt() {
		int n = 0;
	     while (true) {
	            try {
	                n = sc.nextInt();
	              return n;
	            } catch (InputMismatchException e) {
	            	try {
	    				throw new InvalidNumberException();
	    			} catch (InvalidNumberException ex) {
	                System.out.println(Texto.RED_BACKGROUND+ex.getMessage());
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
