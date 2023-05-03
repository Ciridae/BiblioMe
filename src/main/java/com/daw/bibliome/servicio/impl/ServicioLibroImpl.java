package com.daw.bibliome.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.daw.bibliome.dao.LibroDao;
import com.daw.bibliome.dao.modelo.Autor;
import com.daw.bibliome.dao.modelo.Libro;
import com.daw.bibliome.excepciones.LibroException;
import com.daw.bibliome.servicio.ServicioLibro;

@Service
@Primary
public class ServicioLibroImpl implements ServicioLibro {

	@Autowired
	private LibroDao libroDao;

	@Override
	public List<Libro> consultar() {
		List<Libro> libros = this.libroDao.findAll();
		if (libros.isEmpty()) {
			return libros;
		}
		return libros;
	}

	@Override
	public Libro consultar(Integer libroIsbn) throws LibroException {
		Optional<Libro> resultado = this.libroDao.findById(libroIsbn);

		if (resultado.isPresent()) {
			return resultado.get();
		}

		throw new LibroException("No se ha encontrado el libro con ISBN " + libroIsbn);
	}

	@Override
	public List<Libro> consultarPorAutor(Autor autor) throws LibroException {
		List<Libro> libros = this.libroDao.findByAutor(autor);

		if (libros.isEmpty()) {
			throw new LibroException("No se han encontrado libros del autor con id " + autor.getId());
		}

		return libros;
	}

	@Override
	public void crear(Libro libro) throws LibroException {
		try {
			Optional<Libro> resultado = this.libroDao.findById(libro.getIsbn());
			if (resultado.isPresent()) {
				throw new LibroException("El libro con ISBN " + libro.getIsbn() + " ya existe.");
			}
		} catch (EmptyResultDataAccessException e) {
		}

		this.libroDao.save(libro);
	}

	@Override
	public void modificar(Libro libro) throws LibroException {
		try {
			this.consultar(libro.getIsbn());
			this.libroDao.save(libro);
		} catch (EmptyResultDataAccessException e) {
			throw new LibroException("El libro con ISBN " + libro.getIsbn() + " no existe.");
		}
	}

	@Override
	public void eliminar(Integer libroIsbn) throws LibroException {
		try {
			this.libroDao.delete(this.consultar(libroIsbn));
		} catch (EmptyResultDataAccessException e) {
			throw new LibroException("El libro con ISBN " + libroIsbn + " no existe.");
		}
	}

}
