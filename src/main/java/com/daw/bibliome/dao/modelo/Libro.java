package com.daw.bibliome.dao.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libro")
@Data
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISBN", nullable = false, length = 3)
	private Integer isbn;
	
	@Column(name = "titulo", nullable = false, length = 60)
	private String titulo;
	
	@Column(name = "sinopsis", nullable = false)
	private String sinopsis;
	
	@Column(name = "num_paginas", nullable = false, length = 4)
	private Integer numPaginas;
	
	@Column(name = "img", nullable = false, length = 100)
	private String img;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "id_autor")
	private Integer idAutor;
	
	@Column(name = "id_genero")
	private Integer idGenero;

}
