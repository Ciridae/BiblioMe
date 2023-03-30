package com.daw.bibliome.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Libro;

public interface LibroDao extends JpaRepository<Libro, Integer> {

}
