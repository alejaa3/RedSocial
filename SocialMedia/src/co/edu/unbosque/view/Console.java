package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.Texto;

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
	              break;
	            } catch (InputMismatchException e) {
	                System.out.println(Texto.RED_BACKGROUND+"Error: No es un número válido. Intente nuevamente."+Texto.RESET);
	                sc.nextLine(); // Limpiar el buffer del scanner
	            }
	        }
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
