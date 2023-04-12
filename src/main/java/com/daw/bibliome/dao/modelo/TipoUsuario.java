package com.daw.bibliome.dao.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, length = 2)
	private Integer id;

	@Column(name = "tipo", nullable = false, length = 30)
	private String tipo;

	@Column(name = "permisos", nullable = false, length = 2)
	private Integer permisos;

	public TipoUsuario() {
		super();
	}

	public TipoUsuario(Integer id, String tipo, Integer permisos) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.permisos = permisos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getPermisos() {
		return permisos;
	}

	public void setPermisos(Integer permisos) {
		this.permisos = permisos;
	}

}
