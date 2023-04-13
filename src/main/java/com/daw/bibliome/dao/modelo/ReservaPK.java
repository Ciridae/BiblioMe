package com.daw.bibliome.dao.modelo;

import java.io.Serializable;
import java.util.Date;

public class ReservaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6675550594825480466L;

	private Libro libro;

	private Usuario usuario;

	private Date fechaReserva;

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

}
