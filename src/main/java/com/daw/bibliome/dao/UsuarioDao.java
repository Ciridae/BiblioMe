package com.daw.bibliome.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.bibliome.dao.modelo.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

}
