package com.daw.bibliome.dao.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, length = 2)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;

	@Column(name = "img", nullable = false, length = 100)
	private String img;

	public Autor() {
		super();
	}

	public Autor(Integer id, String nombre, String apellidos, String img) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
