package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutor")
public class Tutor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTutor;

	@Column(name="correo_electronico", nullable=false, length=50)
	private String correo;
	
	@Column(name="contrasena", nullable=false, length=50)
	private String contrasena;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=50)
	private String apellido;

	@Column(name="dni", nullable=false, length=9)
	private int dni;
	
	@Column(name="telefono", nullable=false, length=9)
	private int telefono;
	
	@Column(name="nombre_de_la_univerdidad", nullable=false, length=60)
	private String nombre_uni;
	
	@Column(name="carrera_universitaria", nullable=false, length=60)
	private String carrera_uni;

	public Tutor() {
		super();
	}

	public Tutor(int idTutor, String correo, String contrasena, String nombre, String apellido, int dni, int telefono,
			String nombre_uni, String carrera_uni) {
		super();
		this.idTutor = idTutor;
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.nombre_uni = nombre_uni;
		this.carrera_uni = carrera_uni;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre_uni() {
		return nombre_uni;
	}

	public void setNombre_uni(String nombre_uni) {
		this.nombre_uni = nombre_uni;
	}

	public String getCarrera_uni() {
		return carrera_uni;
	}

	public void setCarrera_uni(String carrera_uni) {
		this.carrera_uni = carrera_uni;
	}



	
}
