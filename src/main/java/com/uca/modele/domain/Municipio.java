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

@Entity
@Table(schema = "public", name = "municipio")
public class Municipio {
	
	@Id
    @GeneratedValue(generator="municipio_id_municipio_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "municipio_id_municipio_seq", sequenceName = "public.municipio_id_municipio_seq", allocationSize = 1)
	@Column(name = "id_municipio")
	private Integer id_municipio;
	
	@Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nombre")
	private String nombre; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dpto")
	private Integer id_dpto; 
	
	@OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	@OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY)
	private List<Escuelas> escuelas;
	
	public Municipio() {

	}

	public Municipio(Integer id_municipio, String nombre, Integer id_dpto, List<Cuenta> cuentas,
			List<Escuelas> escuelas) {
		super();
		this.id_municipio = id_municipio;
		this.nombre = nombre;
		this.id_dpto = id_dpto;
		this.cuentas = cuentas;
		this.escuelas = escuelas;
	}

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

	public Integer getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Integer id_dpto) {
		this.id_dpto = id_dpto;
	}

	public List<Cuenta> getUsuarios() {
		return cuentas;
	}

	public void setUsuarios(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public List<Escuelas> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(List<Escuelas> escuelas) {
		this.escuelas = escuelas;
	}

	

}
