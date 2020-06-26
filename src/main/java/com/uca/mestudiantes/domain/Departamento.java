package com.uca.mestudiantes.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "departamento")
public class Departamento {
	@Id
	@Column(name = "id_dpto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_dpto;

	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
	private List<Escuelas> escuelas;

	public Integer getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Integer id_dpto) {
		this.id_dpto = id_dpto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Escuelas> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(List<Escuelas> escuelas) {
		this.escuelas = escuelas;
	}

	public Departamento() {
	}
}
