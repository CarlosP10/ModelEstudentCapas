package com.uca.mestudiantes.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "escuelas")
public class Escuelas {
	@Id
	@Column(name = "id_escuela")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_escuela;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "nombre")
	private String nombre;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "estado")
	private Boolean estado;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "id_dpto")
	private Integer id_dpto;

	public Integer getId_escuela() {
		return id_escuela;
	}

	public void setId_escuela(Integer id_escuela) {
		this.id_escuela = id_escuela;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Integer id_dpto) {
		this.id_dpto = id_dpto;
	}

	public Escuelas() {}

}
