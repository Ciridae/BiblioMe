package com.daw.bibliome.excepciones;

public class AutorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6647888163240565622L;
	
	public AutorException() {
		
	}
	
	public AutorException(String mensajeError) {
		super(mensajeError);
	}

}
