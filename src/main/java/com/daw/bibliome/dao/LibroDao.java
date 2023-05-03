package com.daw.bibliome.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Autor;
import com.daw.bibliome.dao.modelo.Libro;

public interface LibroDao extends JpaRepository<Libro, Integer> {

	List<Libro> findByAutor(Autor autor);

}
