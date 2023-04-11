package com.daw.bibliome.servicio;

import java.util.List;

import com.daw.bibliome.dao.modelo.Libro;
import com.daw.bibliome.excepciones.LibroException;

public interface ServicioLibro {

	List<Libro> consultar();

	Libro consultar(Integer libroIsbn) throws Exception;

	void crear(Libro libro) throws LibroException;

	void modificar(Libro libro) throws LibroException;

	void eliminar(Integer libroIsbn) throws LibroException;

}
