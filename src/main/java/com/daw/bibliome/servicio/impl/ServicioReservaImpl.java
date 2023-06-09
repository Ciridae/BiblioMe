package com.daw.bibliome.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.daw.bibliome.dao.ReservaDao;
import com.daw.bibliome.dao.modelo.Reserva;
import com.daw.bibliome.dao.modelo.ReservaPK;
import com.daw.bibliome.dao.modelo.Usuario;
import com.daw.bibliome.excepciones.ReservaException;
import com.daw.bibliome.servicio.ServicioReserva;

@Service
@Primary
public class ServicioReservaImpl implements ServicioReserva {

	@Autowired
	private ReservaDao reservaDao;

	@Override
	public List<Reserva> consultar() {
		return this.reservaDao.findAll();
	}

	@Override
	public List<Reserva> consultarPorUsuario(Usuario usuario) throws ReservaException {
		List<Reserva> reservas = this.reservaDao.findByReservaPKUsuario(usuario);
		
		if (reservas.isEmpty()) {
			throw new ReservaException("No se ha encontrado ninguna reserva del usuario con ID: " + usuario.getId());
		}
		
		return reservas;
	}

	@Override
	public void crear(Reserva reserva) throws ReservaException {
		try {
			ReservaPK reservaPK = new ReservaPK(reserva.getReservaPK().getLibro(), reserva.getReservaPK().getUsuario(),
					reserva.getReservaPK().getFechaReserva());
			Optional<Reserva> resultado = Optional.ofNullable(this.reservaDao.findByReservaPK(reservaPK));
			if (resultado.isPresent()) {
				throw new ReservaException("La reserva ya existe");
			}
		} catch (EmptyResultDataAccessException e) {

		}

		this.reservaDao.saveAndFlush(reserva);
	}

}
