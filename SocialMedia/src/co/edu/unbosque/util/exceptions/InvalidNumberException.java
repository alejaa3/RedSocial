package co.edu.unbosque.util.exceptions;

import java.util.InputMismatchException;

public class InvalidNumberException extends InputMismatchException {

	public InvalidNumberException() {
		super("por favor ingrese un numero valido");
	}

}
