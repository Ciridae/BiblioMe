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

/**
 * @author Abel Domínguez Morejón
 *
 */
@RestController
// @CrossOrigin(origins = "http://localhost:5000") TODO Agregar la url del frontend para permitir las peticiones
@RequestMapping("/libros")
public class ControladorLibro {

	@Autowired
	private ServicioLibro servicio;

	/**
	 * Obtenemos todos los libros
	 * 
	 * @return 404 si no hay libros, 200 y lista de libros si hay uno o más
	 */
	@GetMapping
	public ResponseEntity<?> consultar() {
		List<Libro> resultado = this.servicio.consultar();

		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(resultado);
		}
	}

	/**
	 * Obtenemos un libro en base a su ISBN
	 * 
	 * @param libroIsbn
	 * @return 404 si no encuentra el libro, 200 y libro si lo encuentra
	 */
	@GetMapping("/{libroIsbn}")
	public ResponseEntity<?> consultar(@PathVariable Integer libroIsbn) {
		try {
			return ResponseEntity.ok(this.servicio.consultar(libroIsbn));
		} catch (LibroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Insertamos un nuevo libro
	 * 
	 * @param libro
	 * @return 409 si ya existe ese ISBN de libro, 201 y el libro insertado si no
	 *         existe
	 */
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Libro libro) {
		try {
			this.servicio.crear(libro);

			return new ResponseEntity<>("El libro " + libro.getTitulo() + " se ha creado correctamente.",
					HttpStatus.CREATED);
		} catch (LibroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	/**
	 * Editamos un libro en base a su ISBN
	 * 
	 * @param libroIsbn
	 * @param libro
	 * @return 400 si no se actualiza correctamente, 200 si la edición tiene éxito
	 */
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

	/**
	 * Eliminamos un libro en base a su ISBN
	 * 
	 * @param libroIsbn
	 * @return 404 si no encuentra el libro, 204 si lo encuentra y lo elimina
	 */
	@DeleteMapping("/{libroIsbn}")
	public ResponseEntity<?> eliminar(@PathVariable Integer libroIsbn) {
		try {
			this.servicio.eliminar(libroIsbn);

			return new ResponseEntity<>("El libro con ISBN " + libroIsbn + " ha sido actualizado correctamente.",
					HttpStatus.NO_CONTENT);
		} catch (LibroException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
