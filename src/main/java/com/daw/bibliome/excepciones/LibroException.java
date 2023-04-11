package com.daw.bibliome.excepciones;

@SuppressWarnings("serial")
public class LibroException extends Exception {

	public LibroException() {

	}
	
	public LibroException(String mensajeError) {
		super(mensajeError);
	}
}
