package com.uca.mestudiantes.domain;

import java.util.Date;
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
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "expediente")
public class Expediente {
	@Id
	@Column(name = "id_expediente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_expediente;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "nombres")
	private String nombres;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "apellidos")
	private String apellidos;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "edad")
	private Integer edad;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "direccion")
	private String direccion;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "telefono_fijo")
	private Integer telefono_fijo;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "telefono_movil")
	private Integer telefono_movil;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_escuela")
	private Escuelas id_escuela;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "nombre_padre")
	private String nombre_padre;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "nombre_madre")
	private String nombre_madre;
	
	@OneToMany(mappedBy = "expediente", fetch = FetchType.EAGER)
	private List<MateriasxAlumno> materiasxAlumnos;

	public Integer getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Integer id_expediente) {
		this.id_expediente = id_expediente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono_fijo() {
		return telefono_fijo;
	}

	public void setTelefono_fijo(Integer telefono_fijo) {
		this.telefono_fijo = telefono_fijo;
	}

	public Integer getTelefono_movil() {
		return telefono_movil;
	}

	public void setTelefono_movil(Integer telefono_movil) {
		this.telefono_movil = telefono_movil;
	}

	public Escuelas getId_escuela() {
		return id_escuela;
	}

	public void setId_escuela(Escuelas id_escuela) {
		this.id_escuela = id_escuela;
	}

	public String getNombre_padre() {
		return nombre_padre;
	}

	public void setNombre_padre(String nombre_padre) {
		this.nombre_padre = nombre_padre;
	}

	public String getNombre_madre() {
		return nombre_madre;
	}

	public void setNombre_madre(String nombre_madre) {
		this.nombre_madre = nombre_madre;
	}

	public List<MateriasxAlumno> getMateriasxAlumnos() {
		return materiasxAlumnos;
	}

	public void setMateriasxAlumnos(List<MateriasxAlumno> materiasxAlumnos) {
		this.materiasxAlumnos = materiasxAlumnos;
	}

	public Expediente() {}
	
	

}
