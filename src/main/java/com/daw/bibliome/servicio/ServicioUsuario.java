package com.daw.bibliome.servicio;

import java.util.List;
import java.util.Map;

import com.daw.bibliome.dao.modelo.Usuario;
import com.daw.bibliome.excepciones.UsuarioException;

public interface ServicioUsuario {
	
	List<Usuario> consultar();
	
	Usuario consultar(Integer id) throws UsuarioException;

	Usuario consultarPorEmail(String email) throws UsuarioException;

	Usuario login(Map<String, String> usuario) throws UsuarioException;

}
