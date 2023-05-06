package com.daw.bibliome.dao.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

	@Column(name = "isbn_libro")
	private Integer isbn;

	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "fecha_reserva")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaReserva;

	public ReservaPK() {
		super();
	}

	public ReservaPK(Integer isbn, Integer id, Date fechaReserva) {
		super();
		this.isbn = isbn;
		this.id = id;
		this.fechaReserva = fechaReserva;
	}

//	public ReservaPK(Libro libro, Usuario usuario, Date fechaReserva) {
//		super();
//		this.libro = libro;
//		this.usuario = usuario;
//		this.fechaReserva = fechaReserva;
//	}
//
//	public Libro getLibro() {
//		return libro;
//	}
//
//	public void setLibro(Libro libro) {
//		this.libro = libro;
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

}
