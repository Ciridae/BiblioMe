package com.daw.bibliome.servicio;

import java.util.List;

import com.daw.bibliome.dao.modelo.Autor;
import com.daw.bibliome.excepciones.AutorException;

public interface ServicioAutor {
	
	List<Autor> consultar();
	
	Autor consultar(Integer id) throws AutorException;

}
