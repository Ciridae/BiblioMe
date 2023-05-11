package com.daw.bibliome.dao.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class ReservaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6675550594825480466L;

//	private Libro libro;
//
//	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "isbn_libro")
	private Libro libro;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "fecha_reserva")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaReserva;

	public ReservaPK() {
		super();
	}

	public ReservaPK(Libro libro, Usuario usuario, Date fechaReserva) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

}
