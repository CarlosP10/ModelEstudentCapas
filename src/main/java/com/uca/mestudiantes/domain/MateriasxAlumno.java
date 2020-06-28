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
import javax.validation.constraints.NotEmpty;
import com.uca.mestudiantes.domain.*;

@Entity
@Table(schema = "public", name = "materiaxalumno")
public class MateriasxAlumno {
	@Id
	@Column(name = "id_materiaexp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_materiaexp;
		
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_expediente")
	private Expediente id_expediente;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_ciclo")
	private Ciclo id_ciclo;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_materia")
	private Materias id_materia;
	
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

	public Expediente getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Expediente id_expediente) {
		this.id_expediente = id_expediente;
	}

	public Ciclo getId_ciclo() {
		return id_ciclo;
	}

	public void setId_ciclo(Ciclo id_ciclo) {
		this.id_ciclo = id_ciclo;
	}

	public Materias getId_materia() {
		return id_materia;
	}

	public void setId_materia(Materias id_materia) {
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
