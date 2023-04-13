package com.daw.bibliome.excepciones;

public class UsuarioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2877946295775892910L;

	public UsuarioException() {

	}

	public UsuarioException(String mensajeError) {
		super(mensajeError);
	}

}
