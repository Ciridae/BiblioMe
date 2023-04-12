package com.daw.bibliome.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Autor;

public interface AutorDao extends JpaRepository<Autor, Integer> {

}
