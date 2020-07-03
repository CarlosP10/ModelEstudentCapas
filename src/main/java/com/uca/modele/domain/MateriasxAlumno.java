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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "materiaxalumno")
public class MateriasxAlumno {
	
	@Id
	@GeneratedValue(generator = "materiaxalumno_id_materiaexp_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "materiaxalumno_id_materiaexp_seq", sequenceName = "public.materiaxalumno_id_materiaexp_seq", allocationSize = 1)
	@Column(name = "id_materiaexp")
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
	
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "anio")
	private Integer anio;
	
    @Size(min=0, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nota")
	private Double nota;
    
    public MateriasxAlumno() {

    }

	public MateriasxAlumno(Integer id_materiaexp, Expediente id_expediente, Ciclo id_ciclo, Materias id_materia,
			@NotBlank(message = "Este campo no puede estar vacío.") Integer anio,
			@Size(min = 0, message = "El nombre debe tener entre 1 y 50 caracteres.") @NotBlank(message = "Este campo no puede estar vacío.") Double nota) {
		super();
		this.id_materiaexp = id_materiaexp;
		this.id_expediente = id_expediente;
		this.id_ciclo = id_ciclo;
		this.id_materia = id_materia;
		this.anio = anio;
		this.nota = nota;
	}

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
    
    
    

}

