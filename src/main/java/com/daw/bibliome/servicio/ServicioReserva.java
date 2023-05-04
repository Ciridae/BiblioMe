package com.daw.bibliome.servicio;

import java.util.List;

import com.daw.bibliome.dao.modelo.Reserva;
import com.daw.bibliome.excepciones.ReservaException;

public interface ServicioReserva {

	List<Reserva> consultar();

	void crear(Reserva reserva) throws ReservaException;

}
