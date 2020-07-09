package com.uca.modele.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

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

	@NotNull(message = "No puede estar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "edad")
	private Integer edad;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "direccion")
	private String direccion;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 9, max = 9, message = "Debe contener 9 caracteres")
	@Column(name = "carnet_min")
	private String numerocarnet;

	@Column(name = "telefono_fijo")
	@Range(min = 00000001,max=99999999, message = "El número de teléfono debe contener exactamente 8 dígitos.")
	@NotNull(message = "Este campo no puede estar vacío.")
	private Integer telefonoFijo;

	@Column(name = "telefono_movil")
	@Range(min = 00000001,max=99999999, message = "El número de teléfono debe contener exactamente 8 dígitos.")
	@NotNull(message = "Este campo no puede estar vacío.")
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
	
	@OneToMany(mappedBy = "expediente", fetch = FetchType.LAZY)
	private List<MateriasxAlumno> materiasxEstudiantes;
	
	@Transient
    private Integer cEscuela;
	
	public Integer getcEscuela() {
		return cEscuela;
	}

	public void setcEscuela(Integer cEscuela) {
		this.cEscuela = cEscuela;
	}

	@Transient
    private Integer aprobadas;

    @Transient
    private Integer reprobadas;

    @Transient
    private Float promedio;       

	public Integer getAprobadas() {
		return aprobadas;
	}

	public void setAprobadas(Integer aprobadas) {
		this.aprobadas = aprobadas;
	}

	public Integer getReprobadas() {
		return reprobadas;
	}

	public void setReprobadas(Integer reprobadas) {
		this.reprobadas = reprobadas;
	}

	public Float getPromedio() {
		return promedio;
	}

	public void setPromedio(Float promedio) {
		this.promedio = promedio;
	}

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

	public Expediente() {}

	public Integer getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Integer idExpediente) {
		this.idExpediente = idExpediente;
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

	public void setTelefonoFijo(Integer telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Integer getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(Integer telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public List<MateriasxAlumno> getMateriasxEstudiantes() {
		return materiasxEstudiantes;
	}

	public void setMateriasxEstudiantes(List<MateriasxAlumno> materiasxEstudiantes) {
		this.materiasxEstudiantes = materiasxEstudiantes;
	}

	public String getNumerocarnet() {
		return numerocarnet;
	}

	public void setNumerocarnet(String numerocarnet) {
		this.numerocarnet = numerocarnet;
	}
	
	public String getFechaDelegate(){
		if(this.fechaNacimiento == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String shortdate = sdf.format(this.fechaNacimiento.getTime());
			return shortdate;
		}
	}


}

