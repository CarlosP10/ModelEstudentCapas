package com.uca.mestudiantes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "ciclo")
public class Ciclo {
	@Id
	@Column(name = "id_ciclo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ciclo;
			
	@Column(name = "ciclo")
	private String ciclo;

	public Integer getId_ciclo() {
		return id_ciclo;
	}

	public void setId_ciclo(Integer id_ciclo) {
		this.id_ciclo = id_ciclo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Ciclo() {}

	
}
