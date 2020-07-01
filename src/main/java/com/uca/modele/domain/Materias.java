package com.uca.modele.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "materias")
public class Materias {
	@Id
	@Column(name = "id_materia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_materia;
	
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

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
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

	public Materias() {}
	
	

}
