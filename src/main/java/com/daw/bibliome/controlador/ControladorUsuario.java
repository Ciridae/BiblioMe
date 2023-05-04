package com.daw.bibliome.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.bibliome.dao.modelo.Usuario;
import com.daw.bibliome.excepciones.UsuarioException;
import com.daw.bibliome.servicio.ServicioUsuario;

/**
 * @author Abel Domínguez Morejón
 *
 */
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

	@Autowired
	private ServicioUsuario servicioUsuario;

	/**
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> consultar() {
		List<Usuario> resultado = this.servicioUsuario.consultar();

		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(resultado);
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> consultar(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(this.servicioUsuario.consultar(id));
		} catch (UsuarioException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> consultar(@PathVariable String email) {
		try {
			return ResponseEntity.ok(this.servicioUsuario.consultarPorEmail(email));
		} catch (UsuarioException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> usuario) {
		try {
			return ResponseEntity.ok(this.servicioUsuario.login(usuario));
		} catch (UsuarioException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
