package com.uca.mestudiantes.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema = "public", name = "cuenta")
public class Cuenta {
	@Id
	@Column(name = "id_cuenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cuenta;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "nombre")
	private String nombre;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "apellido")
	private String apellido;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "fecha_nac")
	private Date fecha_nac;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "edad")
	private Integer edad;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_dpto")
	private Departamento id_dpto;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_municipio")
	private Municipio id_municipio;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "direccion")
	private String direccion;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "estado")
	private Boolean estado;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "nombre_usuario")
	private String nombre_usuario;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "id_tipo")
	private TipoUsuario id_tipo;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")	
	@Column(name = "sesion")
	private Boolean sesion;

	public Integer getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Integer id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Departamento getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Departamento id_dpto) {
		this.id_dpto = id_dpto;
	}

	public Municipio getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Municipio id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public TipoUsuario getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(TipoUsuario id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Boolean getSesion() {
		return sesion;
	}

	public void setSesion(Boolean sesion) {
		this.sesion = sesion;
	}

	public Cuenta() {}
	
	
	
	
	

}
