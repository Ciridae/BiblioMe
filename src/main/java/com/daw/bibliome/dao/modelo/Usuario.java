package com.daw.bibliome.dao.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, length = 2)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellidos", nullable = false, length = 60)
	private String apellidos;

	@Column(name = "email", nullable = false, length = 60)
	private String email;

	@Column(name = "password", nullable = false, length = 150)
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_tipo_usuario")
	@Column(name = "id_tipo_usuario", nullable = false, length = 2)
	private TipoUsuario tipoUsuario;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nombre, String apellidos, String email, String password,
			TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
