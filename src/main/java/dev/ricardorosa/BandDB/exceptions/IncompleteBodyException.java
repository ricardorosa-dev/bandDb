package dev.ricardorosa.BandDB.exceptions;

public class IncompleteBodyException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IncompleteBodyException(String item, String attributes) {
		super("Incomplete body: the " + item + " must have " + attributes + " attributes.");
	}
}
