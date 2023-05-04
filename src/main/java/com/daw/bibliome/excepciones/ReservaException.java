package com.daw.bibliome.excepciones;

@SuppressWarnings("serial")
public class ReservaException extends Exception {

	public ReservaException() {

	}

	public ReservaException(String mensajeError) {
		super(mensajeError);
	}
}
