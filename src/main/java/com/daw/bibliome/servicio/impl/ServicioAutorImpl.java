package com.daw.bibliome.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.daw.bibliome.dao.AutorDao;
import com.daw.bibliome.dao.modelo.Autor;
import com.daw.bibliome.excepciones.AutorException;
import com.daw.bibliome.servicio.ServicioAutor;

@Service
@Primary
public class ServicioAutorImpl implements ServicioAutor {
	
	@Autowired
	private AutorDao autorDao;
	
	@Override
	public List<Autor> consultar() {
		return this.autorDao.findAll();
	}

	@Override
	public Autor consultar(Integer id) throws AutorException {
		Optional<Autor> resultado = this.autorDao.findById(id);
		
		if (resultado.isPresent()) {
			return resultado.get();
		}
		
		throw new AutorException("No se ha encontrado el autor con ID " + id);
	}

}
