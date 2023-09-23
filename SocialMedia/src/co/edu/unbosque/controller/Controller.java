package co.edu.unbosque.controller;

import co.edu.unbosque.view.Console;

public class Controller {
	
	private Console console;
	
	public Controller() {
		console = new Console();
	}
	
	public void run() {
		
		while(true) {
			int opc = console.readInt();
			switch (opc) {
			case 1: {
				
				break;
			}case 2: {
				
				break;
			}case 3: {
				
				break;
			}case 4: {
				
				System.exit(1);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opc);
			}
			
			
			
			
		}
		
	}

}
