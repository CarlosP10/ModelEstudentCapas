package com.uca.mestudiantes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "public", name = "materiaxalumno")
public class MateriasxAlumno {
	@Id
	@Column(name = "id_materiaexp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_materiaexp;
		
	@Column(name = "id_expediente")
	private Integer id_expediente;
	
	@NotEmpty(message = "No puede estar vacio")	
	@Column(name = "id_ciclo")
	private Integer id_ciclo;
	
	@NotEmpty(message = "No puede estar vacio")
	@Column(name = "id_materia")
	private Integer id_materia;
	
	@NotEmpty(message = "No puede estar vacio")
	@Column(name = "anio")
	private Integer anio;
	
	@NotEmpty(message = "No puede estar vacio")
	@Column(name = "nota")
	private Double nota;

	public Integer getId_materiaexp() {
		return id_materiaexp;
	}

	public void setId_materiaexp(Integer id_materiaexp) {
		this.id_materiaexp = id_materiaexp;
	}

	public Integer getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Integer id_expediente) {
		this.id_expediente = id_expediente;
	}

	public Integer getId_ciclo() {
		return id_ciclo;
	}

	public void setId_ciclo(Integer id_ciclo) {
		this.id_ciclo = id_ciclo;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public MateriasxAlumno() {}
	
	

}
