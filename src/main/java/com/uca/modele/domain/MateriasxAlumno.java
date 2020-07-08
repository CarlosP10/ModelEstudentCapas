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
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
	
    @NotNull(message = "Este campo no puede estar vacío.")
    @Range(min = 2001,max=2021, message = "El año debe ser desde 2001 hasta 2021.")
	@Column(name = "anio")
	private Integer anio;
	
    @DecimalMin(value = "0.0", message = "Debe ser decimal")
    @Digits(integer = 2, fraction = 2, message = "Debe ser decimal")
    @Max(value = 10)
    @NotNull(message = "Este campo no puede estar vacío.")
	@Column(name = "nota")
	private Double nota;	
    
    public MateriasxAlumno() {}

	public Integer getIdMateriaexp() {
		return idMateriaexp;
	}

	public void setIdMateriaexp(Integer idMateriaexp) {
		this.idMateriaexp = idMateriaexp;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Materias getMateria() {
		return materia;
	}

	public void setMateria(Materias materia) {
		this.materia = materia;
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
	
	public String getResultadoDelegate() {
		if(this.nota >= 6) {
			return "Aprobado";
		} else {
			return "Reprobado";
		}
	}   

}

