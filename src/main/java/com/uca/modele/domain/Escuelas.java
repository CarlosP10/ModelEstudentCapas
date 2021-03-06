package com.uca.modele.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(schema = "public", name = "escuelas")
public class Escuelas {
	
	@Id
    @GeneratedValue(generator="escuelas_id_escuela_seq",strategy = GenerationType.AUTO)
    @Column(name = "id_escuela")
	private Integer idEscuela;
	
	@Size(min=1, message = "El nombre debe tener entre 1 y 15 caracteres.")
//    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private Boolean estado; 
	
    @Size(min=1, max=75, message = "El nombre debe tener entre 1 y 50 caracteres.")
//    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "descripcion")
	private String descripcion; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio")
	private Municipio municipio; 
		
	@OneToMany(mappedBy = "escuela", fetch = FetchType.LAZY)
    private List<Expediente> expedientes;

	public Integer getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(Integer idEscuela) {
		this.idEscuela = idEscuela;
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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	
	public Escuelas() {}
    

}
