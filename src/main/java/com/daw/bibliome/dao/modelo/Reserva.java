package com.daw.bibliome.dao.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@ManyToOne
	@JoinColumn(name = "isbn_libro")
	@Column(name = "isbn_libro", nullable = false, length = 2)
	private Libro libro;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@Column(name = "id_usuario", nullable = false, length = 2)
	private Usuario usuario;

	@Id
	@Column(name = "fecha_reserva", nullable = false)
	private Date fechaReserva;

	public Reserva() {
		super();
	}

	public Reserva(Libro libro, Usuario usuario, Date fechaReserva) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fechaReserva = fechaReserva;
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

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

}
