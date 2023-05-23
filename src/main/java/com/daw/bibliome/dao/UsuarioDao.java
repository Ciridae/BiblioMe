package com.daw.bibliome.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.bibliome.dao.modelo.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	@Query(value = "SELECT * FROM usuario u WHERE u.email = ?1", nativeQuery = true)
	Optional<Usuario> findByEmail(String email);

}
