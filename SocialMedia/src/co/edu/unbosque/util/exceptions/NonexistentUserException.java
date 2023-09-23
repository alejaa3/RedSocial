package co.edu.unbosque.util.exceptions;

import java.util.InputMismatchException;

public class NonexistentUserException extends InputMismatchException {

	public NonexistentUserException() {
		super("usuario no encontrado");
	}

}
