package com.daw.bibliome.dao.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
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

	@Column(name = "id_autor", length = 2)
	private Integer idAutor;

	@Column(name = "id_genero", length = 2)
	private Integer idGenero;

	public Libro() {
		super();
	}

	public Libro(Integer isbn, String titulo, String sinopsis, Integer numPaginas, String img, String estado,
			Integer idAutor, Integer idGenero) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.numPaginas = numPaginas;
		this.img = img;
		this.estado = estado;
		this.idAutor = idAutor;
		this.idGenero = idGenero;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

}
