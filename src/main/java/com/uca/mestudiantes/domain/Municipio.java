package com.uca.mestudiantes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "municipio")
public class Municipio {
	@Id
	@Column(name = "id_municipio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_municipio;
			
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_dpto")
	private Departamento id_dpto;

	public Integer getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Departamento id_dpto) {
		this.id_dpto = id_dpto;
	}
	
	public Municipio() {}

}
