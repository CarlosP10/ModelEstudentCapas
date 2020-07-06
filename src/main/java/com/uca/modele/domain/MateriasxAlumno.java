package com.uca.modele.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "materiaxalumno")
public class MateriasxAlumno {
	
	@Id
	@GeneratedValue(generator = "materiaxalumno_id_materiaexp_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "materiaxalumno_id_materiaexp_seq", sequenceName = "public.materiaxalumno_id_materiaexp_seq", allocationSize = 1)
	@Column(name = "id_materiaexp")
	private Integer idMateriaexp;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_expediente")
	private Expediente expediente;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_ciclo")
	private Ciclo ciclo;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_materia")
	private Materias materia;
	
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "anio")
	private Integer anio;
	
    @Size(min=0, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nota")
	private Double nota;
    
    public MateriasxAlumno() {}

	public Integer getIdMateriaexp() {
		return idMateriaexp;
	}

	public void setIdMateriaexp(Integer id_materiaexp) {
		this.idMateriaexp = id_materiaexp;
	}

	public Expediente getIdExpediente() {
		return expediente;
	}

	public void setIdExpediente(Expediente id_expediente) {
		this.expediente = id_expediente;
	}

	public Ciclo getIdCiclo() {
		return ciclo;
	}

	public void setIdCiclo(Ciclo id_ciclo) {
		this.ciclo = id_ciclo;
	}

	public Materias getIdMateria() {
		return materia;
	}

	public void setIdMateria(Materias id_materia) {
		this.materia = id_materia;
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
    
    
    

}

