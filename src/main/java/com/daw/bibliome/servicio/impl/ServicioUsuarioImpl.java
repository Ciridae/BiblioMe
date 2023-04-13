package com.daw.bibliome.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.daw.bibliome.dao.UsuarioDao;
import com.daw.bibliome.dao.modelo.Usuario;
import com.daw.bibliome.excepciones.UsuarioException;
import com.daw.bibliome.servicio.ServicioUsuario;

@Service
@Primary
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public List<Usuario> consultar() {
		return this.usuarioDao.findAll();
	}

	@Override
	public Usuario consultar(Integer id) throws UsuarioException {
		Optional<Usuario> resultado = this.usuarioDao.findById(id);

		if (resultado.isPresent()) {
			return resultado.get();
		}

		throw new UsuarioException("No se ha encontrado el usuario con ID " + id);
	}

}
