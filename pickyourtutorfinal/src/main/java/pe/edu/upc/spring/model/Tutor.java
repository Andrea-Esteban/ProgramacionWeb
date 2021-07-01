package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tutor")
public class Tutor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTutor;

	@NotBlank(message = "Debe ingresar correo")
	@Column(name="correo_electronico", nullable=false, length=50)
	private String correo;
	
	@NotBlank(message = "Debe ingresar contrase&ntilde;a")
	@Column(name="contrasena", nullable=false, length=50)
	private String contrasena;
	
	@NotBlank(message = "Debe ingresar el nombre")
	@Pattern(regexp = "[A-Za-zñ ]+", message="El nombre solo puede tener letras")
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	@NotBlank(message = "Debe ingresar codigo al alumno")
	@Pattern(regexp = "[A-Za-zñ ]+", message="El apellido solo puede tener letras")
	@Column(name="apellido", nullable=false, length=50)
	private String apellido;

	@NotBlank(message = "Debe ingresar codigo al alumno")
	@Size(min = 8, max = 8, message = "La contrasena solo debe tener 8 digitos")
	@Pattern(regexp = "[0-9]+", message="El teléfono solo puede tener números")
	@Column(name="dni", nullable=false, length=8)
	private String dni;
	
	@NotBlank(message = "Debe ingresar codigo al alumno")
	@Size(min = 9, max = 9, message = "La contrasena solo debe tener 9 digitos")
	@Pattern(regexp = "[0-9]+", message="El teléfono solo puede tener números")
	@Column(name="telefono", nullable=false, length=9)
	private String telefono;
	
	
	@NotBlank(message = "Debe ingresar nombre de  al universidad")
	@Column(name="nombre_uni", nullable=false)
	private String nombre_uni;
	
	@NotBlank(message = "Debe ingresar carrera de la universidad")
	@Column(name="carrera_universitaria", nullable=false)
	private String carrera_uni;
		
	
	


	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Tutor(int idTutor, @NotBlank(message = "Debe ingresar correo") String correo,
			@NotBlank(message = "Debe ingresar contrase&ntilde;a") String contrasena,
			@NotBlank(message = "Debe ingresar el nombre") @Pattern(regexp = "[A-Za-zñ ]+", message = "El nombre solo puede tener letras") String nombre,
			@NotBlank(message = "Debe ingresar codigo al alumno") @Pattern(regexp = "[A-Za-zñ ]+", message = "El apellido solo puede tener letras") String apellido,
			@NotBlank(message = "Debe ingresar codigo al alumno") @Size(min = 8, max = 8, message = "La contrasena solo debe tener 8 digitos") @Pattern(regexp = "[0-9]+", message = "El teléfono solo puede tener números") String dni,
			@NotBlank(message = "Debe ingresar codigo al alumno") @Size(min = 9, max = 9, message = "La contrasena solo debe tener 9 digitos") @Pattern(regexp = "[0-9]+", message = "El teléfono solo puede tener números") String telefono,
			@NotBlank(message = "Debe ingresar nombre de  al universidad") String nombre_uni,
			@NotBlank(message = "Debe ingresar carrera de la universidad") String carrera_uni) {
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





	public String getDni() {
		return dni;
	}





	public void setDni(String dni) {
		this.dni = dni;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
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
