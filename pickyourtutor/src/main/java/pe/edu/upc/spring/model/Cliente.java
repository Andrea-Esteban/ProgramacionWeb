package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCliente;

	@Column(name="Correo Electronico", nullable=false, length=50)
	private String correo;
	
	@Column(name="Contraseña", nullable=false, length=50)
	private String contraseña;
	
	@Column(name="Nombre", nullable=false, length=50)
	private String nombre;
	
	@Column(name="Apellido", nullable=false, length=50)
	private String apellido;

	@Column(name="Dni", nullable=false, length=9)
	private int dni;
	
	@Column(name="Telefono", nullable=false, length=9)
	private int telefono;
	
	@Column(name="Nombre de la univerdidad", nullable=false, length=50)
	private String nombre_uni;
	
	@Column(name="Carrera universitaria", nullable=false, length=50)
	private String carrera_uni;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String correo, String contraseña, String nombre, String apellido, int dni,
			int telefono, String nombre_uni, String carrera_uni) {
		super();
		this.idCliente = idCliente;
		this.correo = correo;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.nombre_uni = nombre_uni;
		this.carrera_uni = carrera_uni;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
