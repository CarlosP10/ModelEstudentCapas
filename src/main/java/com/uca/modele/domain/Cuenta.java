package com.uca.modele.domain;


import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

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
@Table(schema = "public", name = "usuario")
public class Cuenta {

	@Column(name = "nombre_usuario")
    @Size(min=1, max=15, message = "El usuario debe tener entre 1 y 15 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String nombre_usuario;
	
	@Column(name = "nombre")
    @Size(min=1, max=15, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String nombre;
	
	@Column(name = "apellido")
    @Size(min=1, max=15, message = "El apellido debe tener entre 1 y 50 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String apellido;
	
	@Column(name = "fecha_nac")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha de ahora.")
    @NotNull(message = "Este campo no puede estar vacío.")
	private Date fecha_nac;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dpto")
	private Integer id_dpto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;
	
	@Transient
    private Integer cMunicipio;
	
	@Column(name = "direccion")
    @Size(min=1, max=15, message = "La dirección debe tener entre 1 y 200 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String direccion;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "contrasenia")
    @Size(max=50, message = "La contraseña no debe tener más de 50 caracteres.")
    @Size(min=8, message = "La contraseña debe tener como mínimo 8 caracteres.")
    @NotBlank(message = "Este campo no puede estar vacío.")
	private String contrasenia;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
	private Integer id_tipo;
	
	@Column(name = "sesion")
	private Boolean sesion; 
	
	@Id
    @GeneratedValue(generator="cuenta_id_cuenta_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "cuenta_id_cuenta_seq", sequenceName = "public.cuenta_id_cuenta_seq", allocationSize = 1)
    @Column(name = "id_cuenta")
	private Integer id_cuenta;
	
	public Cuenta() {

    }

	public Cuenta(
			@Size(min = 1, max = 15, message = "El usuario debe tener entre 1 y 15 caracteres.") @NotBlank(message = "Este campo no puede estar vacío.") String nombre_usuario,
			@Size(min = 1, max = 15, message = "El nombre debe tener entre 1 y 50 caracteres.") @NotBlank(message = "Este campo no puede estar vacío.") String nombre,
			@Size(min = 1, max = 15, message = "El apellido debe tener entre 1 y 50 caracteres.") @NotBlank(message = "Este campo no puede estar vacío.") String apellido,
			@Past(message = "La fecha de nacimiento debe ser anterior a la fecha de ahora.") @NotNull(message = "Este campo no puede estar vacío.") Date fecha_nac,
			Integer id_dpto, Municipio municipio, Integer cMunicipio,
			@Size(min = 1, max = 15, message = "La dirección debe tener entre 1 y 200 caracteres.") @NotBlank(message = "Este campo no puede estar vacío.") String direccion,
			Boolean estado,
			@Size(max = 50, message = "La contraseña no debe tener más de 50 caracteres.") @Size(min = 8, message = "La contraseña debe tener como mínimo 8 caracteres.") @NotBlank(message = "Este campo no puede estar vacío.") String contrasenia,
			Integer id_tipo, Boolean sesion, Integer id_usuario) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nac = fecha_nac;
		this.id_dpto = id_dpto;
		this.municipio = municipio;
		this.cMunicipio = cMunicipio;
		this.direccion = direccion;
		this.estado = estado;
		this.contrasenia = contrasenia;
		this.id_tipo = id_tipo;
		this.sesion = sesion;
		this.id_cuenta = id_cuenta;
	}



	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
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

	public Integer getId_dpto() {
		return id_dpto;
	}

	public void setId_dpto(Integer id_dpto) {
		this.id_dpto = id_dpto;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getcMunicipio() {
		return cMunicipio;
	}

	public void setcMunicipio(Integer cMunicipio) {
		this.cMunicipio = cMunicipio;
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

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Boolean getSesion() {
		return sesion;
	}

	public void setSesion(Boolean sesion) {
		this.sesion = sesion;
	}

	public Integer getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Integer id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	
	public Integer getEdad(){

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getFecha_nac().getTime());

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate bd = LocalDate.of(year, month, date);

        LocalDate now = LocalDate.now();

        return Period.between(bd, now).getYears();

    }
	
	@Override
    public String toString() {
        return "Usuario{" +
                "id_cuenta=" + id_cuenta +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nac=" + fecha_nac +
                ", municipio=" + municipio +
                ", cMunicipio=" + cMunicipio +
                ", direccion='" + direccion + '\'' +
                ", estado=" + estado +
                ", contrasenia='" + contrasenia + '\'' +
                ", id_tipo=" + id_tipo +
                ", sesion=" + sesion +
                '}';
    }
	
	

	
}