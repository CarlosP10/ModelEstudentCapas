package com.uca.modele.domain;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "cuenta")
public class Cuenta {
	@Id
    @GeneratedValue(generator="cuenta_id_cuenta_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "cuenta_id_cuenta_seq", sequenceName = "public.cuenta_id_cuenta_seq", allocationSize = 1)
    @Column(name = "id_cuenta")
	private Integer idCuenta;
	
	@Column(name = "nombre")
    @Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String nombre;
	
	@Column(name = "apellido")
    @Size(min=1, max=15, message = "El apellido debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String apellido;
	
	@Column(name = "fecha_nac")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha de ahora.")
    @NotNull(message = "Este campo no puede estar vacío.")
	private Date fechaNac;
	
	@Column(name = "edad")
	private Integer edad; //calcular edad
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dpto")
	private Departamento idDpto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;
	
	@Column(name = "direccion")
    @Size(min=1, max=100, message = "La dirección debe tener entre 1 y 200 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String direccion;	
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "nombre_usuario")
    @Size(min=1, max=15, message = "El usuario debe tener entre 1 y 15 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String nombreUsuario;
	
	@Column(name = "contrasenia")
    @Size(max=30, message = "La contraseña no debe tener más de 50 caracteres.")
    @Size(min=8, message = "La contraseña debe tener como mínimo 8 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String contrasenia;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
	private TipoUsuario idTipo;
	
	@Column(name = "sesion")
	private Boolean sesion; 
	
	@Column(name = "descripcion")
    @Size(max=100, message = "La contraseña no debe tener más de 50 caracteres.")
    @Size(min=8, message = "La contraseña debe tener como mínimo 8 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Cuenta() {}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombre_usuario) {
		this.nombreUsuario = nombre_usuario;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fecha_nac) {
		this.fechaNac = fecha_nac;
	}

	public Departamento getIdDpto() {
		return idDpto;
	}

	public void setIdDpto(Departamento id_dpto) {
		this.idDpto = id_dpto;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public TipoUsuario getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(TipoUsuario id_tipo) {
		this.idTipo = id_tipo;
	}

	public Boolean getSesion() {
		return sesion;
	}

	public void setSesion(Boolean sesion) {
		this.sesion = sesion;
	}
	
	public String getFechaDelegate(){
		if(this.fechaNac == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String shortdate = sdf.format(this.fechaNac.getTime());
			return shortdate;
		}
	}
	
	public Integer getEdad(){

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getFechaNac().getTime());

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate bd = LocalDate.of(year, month, date);

        LocalDate now = LocalDate.now();

        return Period.between(bd, now).getYears();

    }
}
