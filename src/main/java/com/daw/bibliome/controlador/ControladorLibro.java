package com.daw.bibliome.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.bibliome.dao.modelo.Libro;
import com.daw.bibliome.excepciones.LibroException;
import com.daw.bibliome.servicio.ServicioLibro;

@RestController
@RequestMapping("/libros")
public class ControladorLibro {

	@Autowired
	private ServicioLibro servicio;

	@GetMapping
	public List<Libro> consultar() {
		return this.servicio.consultar();
	}

	@GetMapping("/{libroIsbn}")
	public ResponseEntity<?> consultar(@PathVariable Integer libroIsbn) {
		try {
			return ResponseEntity.ok(this.servicio.consultar(libroIsbn));
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Libro libro) {
		try {
			this.servicio.crear(libro);
			
			return new ResponseEntity<>("El libro " + libro.getTitulo() + " se ha creado correctamente.",
					HttpStatus.OK);
		} catch (LibroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{libroIsbn}")
	public ResponseEntity<?> modificar(@PathVariable Integer libroIsbn, @RequestBody Libro libro) {
		try {
			this.servicio.modificar(libro);

			return new ResponseEntity<>("El libro " + libro.getTitulo() + " ha sido actualizado correctamente.",
					HttpStatus.OK);
		} catch (LibroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{libroIsbn}")
	public ResponseEntity<?> eliminar(@PathVariable Integer libroIsbn) {
		try {
			this.servicio.eliminar(libroIsbn);
			
			return new ResponseEntity<>("El libro con ISBN " + libroIsbn + " ha sido actualizado correctamente.",
					HttpStatus.OK);
		} catch (LibroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
