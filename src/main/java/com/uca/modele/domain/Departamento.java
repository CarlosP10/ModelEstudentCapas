package com.uca.modele.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "departamento")
public class Departamento {
	
	@Id
    @GeneratedValue(generator="departamento_id_dpto_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "departamento_id_dpto_seq", sequenceName = "public.departamento_id_dpto_seq", allocationSize = 1)
	@Column(name = "id_dpto")
	private Integer idDpto;

	@Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nombre")
	private String nombre;

	public Departamento() {}

	public Integer getIdDpto() {
		return idDpto;
	}

	public void setIdDpto(Integer id_dpto) {
		this.idDpto = id_dpto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

