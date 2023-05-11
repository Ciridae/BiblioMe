package com.daw.bibliome.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Reserva;
import com.daw.bibliome.dao.modelo.ReservaPK;
import com.daw.bibliome.dao.modelo.Usuario;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {

	Reserva findByReservaPK(ReservaPK reservaPK);
	
	List<Reserva> findByReservaPKUsuario(Usuario usuario);

}
