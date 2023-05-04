package com.daw.bibliome.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.bibliome.dao.modelo.Reserva;
import com.daw.bibliome.excepciones.ReservaException;
import com.daw.bibliome.servicio.ServicioReserva;

@RestController
@RequestMapping("/reservas")
public class ControladorReserva {

	@Autowired
	private ServicioReserva servicioReserva;

	@GetMapping
	public ResponseEntity<?> consultar() {
		List<Reserva> resultado = this.servicioReserva.consultar();

		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(resultado);
		}
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Reserva reserva) {
		try {
			this.servicioReserva.crear(reserva);

			return new ResponseEntity<>("La reserva con datos: " + reserva.getReservaPK().getIsbn() + ", "
					+ reserva.getReservaPK().getId() + ", " + reserva.getReservaPK().getFechaReserva() + " se ha creado.", HttpStatus.CREATED);
		} catch (ReservaException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
