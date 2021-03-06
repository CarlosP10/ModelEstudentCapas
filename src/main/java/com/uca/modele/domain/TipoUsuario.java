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
@Table(schema = "public", name = "tipo_usuario")
public class TipoUsuario {
	
	@Id
    @GeneratedValue(generator="tipo_usuario_id_tipo_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "tipo_usuario_id_tipo_seq", sequenceName = "public.tipo_usuario_id_tipo_seq", allocationSize = 1)
	@Column(name = "id_tipo")
	private Integer idTipo;
			
	@Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nombre")
	private String nombre;
	
	public TipoUsuario()  {}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer id_tipo) {
		this.idTipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}