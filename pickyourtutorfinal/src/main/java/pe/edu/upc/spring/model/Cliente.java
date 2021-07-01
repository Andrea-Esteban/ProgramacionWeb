package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCliente;

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

	@NotBlank(message = "Debe ingresar DNI")
	@Size(min = 8, max = 8, message = "La contrasena solo debe tener 8 digitos")
	@Pattern(regexp = "[0-9]+", message="El teléfono solo puede tener números")
	@Column(name="dni", nullable=false, length=8)
	private String dni;
	
	@NotBlank(message = "Debe ingresar el telefono")
	@Size(min = 9, max = 9, message = "La contrasena solo debe tener 9 digitos")
	@Pattern(regexp = "[0-9]+", message="El teléfono solo puede tener números")
	@Column(name="telefono", nullable=false, length=9)
	private String telefono;
	
	
	@NotBlank(message = "Debe ingresar nombre de la universidad")
	@Column(name="nombre_de_la_universidad", nullable=false)
	private String nombre_uni;
	
	@NotBlank(message = "Debe ingresar carrera de la universidad")
	@Column(name="carrera_universitaria", nullable=false)
	private String carrera_uni;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<ResenaTutor> resenaTutores;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente,
			@Size(min = 10, max = 50, message = "El correo electrónico es inválido") String correo,
			@Size(min = 5, max = 20, message = "La contrasena solo debe tener entre 5 a 20 caracteres") String contrasena,
			@Pattern(regexp = "[0-9]+", message = "El nombre solo puede tener letras") String nombre,
			@Pattern(regexp = "[0-9]+", message = "El apellido solo puede tener letras") String apellido,
			@Size(min = 8, max = 28, message = "La contrasena solo debe tener entre 5 a 20 caracteres") @Pattern(regexp = "[A-Za-zñ ]+", message = "El teléfono solo puede tener números") String dni,
			@Size(min = 5, max = 20, message = "La contrasena solo debe tener entre 5 a 20 caracteres") @Pattern(regexp = "[A-Za-zñ ]+", message = "El teléfono solo puede tener números") String telefono,
			@Pattern(regexp = "[0-9]+", message = "El nombre de la universidad solo puede tener letras o números") String nombre_uni,
			@Pattern(regexp = "[0-9]+", message = "El nombre de la carrera solo puede tener letras o números") String carrera_uni,
			Set<ResenaTutor> resenaTutores) {
		super();
		this.idCliente = idCliente;
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.nombre_uni = nombre_uni;
		this.carrera_uni = carrera_uni;
		this.resenaTutores = resenaTutores;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public Set<ResenaTutor> getResenaTutores() {
		return resenaTutores;
	}

	public void setResenaTutores(Set<ResenaTutor> resenaTutores) {
		this.resenaTutores = resenaTutores;
	}

	

	
	
}
