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

	@Column(name = "nacido", nullable = false, length = 100)
	private String nacido;

	@Column(name = "web", nullable = false, length = 100)
	private String web;

	@Column(name = "twitter", nullable = false, length = 100)
	private String twitter;

	@Column(name = "autor_desde", nullable = true, length = 100)
	private String autorDesde;

	@Column(name = "biografia", nullable = true, length = 2000)
	private String biografia;

	public Autor() {
		super();
	}

	public Autor(Integer id, String nombre, String apellidos, String img, String nacido, String web, String twitter,
			String autorDesde, String biografia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.img = img;
		this.nacido = nacido;
		this.web = web;
		this.twitter = twitter;
		this.autorDesde = autorDesde;
		this.biografia = biografia;
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

	public String getNacido() {
		return nacido;
	}

	public void setNacido(String nacido) {
		this.nacido = nacido;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getAutorDesde() {
		return autorDesde;
	}

	public void setAutorDesde(String autorDesde) {
		this.autorDesde = autorDesde;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

}
