package com.daw.bibliome.dao.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "reserva")
//@IdClass(value = ReservaPK.class)
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3989109125610602407L;

//	@Id
//	@ManyToOne
//	@JoinColumn(name = "isbn_libro")
//	private Libro libro;
//
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "id_usuario")
//	private Usuario usuario;
//
//	@Id
//	@Column(name = "fecha_reserva", nullable = false)
//	private Date fechaReserva;

	@EmbeddedId
	private ReservaPK reservaPK;

	public Reserva() {
		super();
	}

	public Reserva(ReservaPK reservaPK) {
		super();
		this.reservaPK = reservaPK;
	}

	public ReservaPK getReservaPK() {
		return reservaPK;
	}

	public void setReservaPK(ReservaPK reservaPK) {
		this.reservaPK = reservaPK;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
