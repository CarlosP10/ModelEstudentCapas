package com.uca.modele.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "expediente")
public class Expediente {

	@Id
	@GeneratedValue(generator = "expediente_id_expediente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "expediente_id_expediente_seq", sequenceName = "public.expediente_id_expediente_seq", allocationSize = 1)
	@Column(name = "id_expediente")
	private Integer idExpediente;

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
	private Date fechaNacimiento;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "edad")
	private Integer edad;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono_fijo")
    @Pattern(regexp = "^[0-9]{8}$", message = "El número de teléfono debe contener exactamente 8 dígitos.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private Integer telefonoFijo;

	@Column(name = "telefono_movil")
	@Pattern(regexp = "^[0-9]{8}$", message = "El número de teléfono debe contener exactamente 8 dígitos.")
	@NotBlank(message = "Este campo no puede estar vacío.")
	private Integer telefonoMovil;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escuela")
	private Escuelas escuela;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "nombre_padre")
	private String nombrePadre;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "nombre_madre")
	private String nombreMadre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	public Escuelas getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuelas escuela) {
		this.escuela = escuela;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@OneToMany(mappedBy = "expediente", fetch = FetchType.LAZY)
	private List<MateriasxAlumno> materiasxEstudiantes;

	public Expediente() {}

	public Integer getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Integer id_expediente) {
		this.idExpediente = id_expediente;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fecha_nacimiento) {
		this.fechaNacimiento = fecha_nacimiento;
	}

	public Integer getEdad() {
		Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getFechaNacimiento().getTime());

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate bd = LocalDate.of(year, month, date);

        LocalDate now = LocalDate.now();

        return Period.between(bd, now).getYears();
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

	public Integer getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(Integer telefono_fijo) {
		this.telefonoFijo = telefono_fijo;
	}

	public Integer getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(Integer telefono_movil) {
		this.telefonoMovil = telefono_movil;
	}

	public Escuelas getIdEscuela() {
		return escuela;
	}

	public void setIdEscuela(Escuelas id_escuela) {
		this.escuela = id_escuela;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombre_padre) {
		this.nombrePadre = nombre_padre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombre_madre) {
		this.nombreMadre = nombre_madre;
	}

	public List<MateriasxAlumno> getMateriasxEstudiantes() {
		return materiasxEstudiantes;
	}

	public void setMateriasxEstudiantes(List<MateriasxAlumno> materiasxEstudiantes) {
		this.materiasxEstudiantes = materiasxEstudiantes;
	}


}

