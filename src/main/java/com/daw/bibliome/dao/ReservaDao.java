package com.daw.bibliome.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Reserva;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {

}
