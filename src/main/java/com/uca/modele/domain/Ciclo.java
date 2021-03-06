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
@Table(schema = "public", name = "ciclo")
public class Ciclo {
	
	@Id
    @GeneratedValue(generator="ciclo_id_ciclo_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ciclo_id_ciclo_seq", sequenceName = "public.ciclo_id_ciclo_seq", allocationSize = 1)
	@Column(name = "id_ciclo")
	private Integer idCiclo;
			
	@Size(min=1)
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "ciclo")
	private String ciclo;

	public Integer getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Integer id_ciclo) {
		this.idCiclo = id_ciclo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Ciclo() {}
	

}

