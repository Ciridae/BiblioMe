package com.daw.bibliome.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.bibliome.dao.modelo.Autor;
import com.daw.bibliome.excepciones.AutorException;
import com.daw.bibliome.servicio.ServicioAutor;

@RestController
@RequestMapping("/autores")
public class ControladorAutor {

	@Autowired
	private ServicioAutor servicioAutor;

	@GetMapping
	public ResponseEntity<?> consultar() {
		List<Autor> resultado = this.servicioAutor.consultar();

		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(resultado);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultar(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(this.servicioAutor.consultar(id));
		} catch (AutorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
