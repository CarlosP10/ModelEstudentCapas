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
import javax.persistence.Transient;
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

	@Column(name = "telefono_fijo")
    @Pattern(regexp = "^[0-9]{8}$", message = "El número de teléfono debe contener exactamente 8 dígitos.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private Integer telefono_fijo;

	@Column(name = "telefono_movil")
	@Pattern(regexp = "^[0-9]{8}$", message = "El número de teléfono debe contener exactamente 8 dígitos.")
	@NotBlank(message = "Este campo no puede estar vacío.")
	private Integer telefono_movil;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escuela")
	private Escuelas escuela;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "nombre_padre")
	private String nombre_padre;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 1, max = 50, message = "Debe contener de 1 a 50 caracteres")
	@Column(name = "nombre_madre")
	private String nombre_madre;
	
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

	public Integer getcEscuela() {
		return cEscuela;
	}

	public void setcEscuela(Integer cEscuela) {
		this.cEscuela = cEscuela;
	}

	@OneToMany(mappedBy = "expediente", fetch = FetchType.LAZY)
	private List<MateriasxAlumno> materiasxEstudiantes;
	
	@Transient
    private Integer cEscuela;

	public Expediente() {}

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
		Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getFecha_nacimiento().getTime());

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
		return escuela;
	}

	public void setId_escuela(Escuelas id_escuela) {
		this.escuela = id_escuela;
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

	public List<MateriasxAlumno> getMateriasxEstudiantes() {
		return materiasxEstudiantes;
	}

	public void setMateriasxEstudiantes(List<MateriasxAlumno> materiasxEstudiantes) {
		this.materiasxEstudiantes = materiasxEstudiantes;
	}
	
	@Override
    public String toString() {
        return "Estudiante{" +
                "id_expediente=" + id_expediente +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", direccion='" + direccion + '\'' +
                ", telefono_movil='" + telefono_movil + '\'' +
                ", telefono_fijo='" + telefono_fijo + '\'' +
                ", id_escuela=" + escuela +
                ", nombre_madre='" + nombre_madre + '\'' +
                ", nombre_padre='" + nombre_padre + '\'' +
                ", materiasxEstudiantes=" + materiasxEstudiantes +
                '}';
    }

}

