package com.daw.bibliome.servicio.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daw.bibliome.dao.UsuarioDao;
import com.daw.bibliome.dao.modelo.TipoUsuario;
import com.daw.bibliome.dao.modelo.Usuario;
import com.daw.bibliome.excepciones.UsuarioException;
import com.daw.bibliome.servicio.ServicioUsuario;

@Service
@Primary
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

	@Override
	public Usuario consultarPorEmail(String email) throws UsuarioException {
		Optional<Usuario> resultado = this.usuarioDao.findByEmail(email);

		if (resultado.isPresent()) {
			return resultado.get();
		}

		throw new UsuarioException("No se ha encontrado el usuario con email " + email);
	}

	@Override
	public Usuario login(Map<String, String> usuario) throws UsuarioException {
		Usuario usuarioPorEmail = this.consultarPorEmail(usuario.get("email"));

		if (this.passwordEncoder.matches(usuario.get("password"), usuarioPorEmail.getPassword())) {
			return usuarioPorEmail;
		}

		throw new UsuarioException("La contraseña es incorrecta");
	}

	@Override
	public void registrar(Usuario usuario) throws UsuarioException {
		if (this.usuarioDao.findByEmail(usuario.getEmail()) != null) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuario.setTipoUsuario(new TipoUsuario(2, "estándar", 2));

			this.usuarioDao.saveAndFlush(usuario);
		} else {
			throw new UsuarioException("Ya existe un usuario con ese email");
		}
	}

}
