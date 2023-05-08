package com.daw.bibliome.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Reserva;
import com.daw.bibliome.dao.modelo.ReservaPK;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {

	Reserva findByReservaPK(ReservaPK reservaPK);
	
	List<Reserva> findByReservaPKId(Integer id);

}
