package dev.ricardorosa.BandDB.exceptions;

public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NotFoundException(String item, Long id) {
		super("There's no " + item + " associated with the id " + id + ".");
	}
}
