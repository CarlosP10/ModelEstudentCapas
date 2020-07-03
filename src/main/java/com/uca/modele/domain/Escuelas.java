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
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(schema = "public", name = "escuela")
public class Escuelas {
	
	@Id
    @GeneratedValue(generator="escuelas_id_escuela_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "escuelas_id_escuela_seq", sequenceName = "public.escuelas_id_escuela_seq", allocationSize = 1)
    @Column(name = "id_escuela")
	private Integer id_escuela;
	
	@Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "nombre")
	private String nombre;
	
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "estado")
	private Boolean estado; 
	
    @Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	@Column(name = "descripcion")
	private String descripcion; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dpto")
	private Integer id_dpto; 
	
	@OneToMany(mappedBy = "escuela", fetch = FetchType.LAZY)
    private List<Expediente> expedientes;

    @Transient
    private Integer cDpto;
    
    @Override
    public String toString() {
        return "Escuela{" +
                "id:escuela=" + id_escuela +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", id_dpto=" + id_dpto +
                ", descripcion=" + descripcion +
                ", estudiantes=" + expedientes +
                ", cDpto=" + cDpto +
                '}';
    }

    public Escuelas() {

    }

	public Escuelas(Integer id_escuela, String nombre, Boolean estado, String descripcion, Integer id_dpto,
			List<Expediente> expedientes, Integer cDpto) {
		super();
		this.id_escuela = id_escuela;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
		this.id_dpto = id_dpto;
		this.expedientes = expedientes;
		this.cDpto = cDpto;
	}

	public Integer getId_escuela() {
		return id_escuela;
	}

	public void setId_escuela(Integer id_escuela) {
		this.id_escuela = id_escuela;
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

	public Integer getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Integer id_dpto) {
		this.id_dpto = id_dpto;
	}

	public List<Expediente> getEstudiantes() {
		return expedientes;
	}

	public void setEstudiantes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public Integer getcDpto() {
		return cDpto;
	}

	public void setcDpto(Integer cDpto) {
		this.cDpto = cDpto;
	}
    
    

}
