package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int idCliente;
	

	@Column(name= "correoCliente",nullable=false,length=50)
	private String correoCliente;
	
	@Column(name= "contraseñaCliente",nullable=false,length=50)
	private String contraseñaCliente ;
	
	@Size(min = 8, max=8)
	@Pattern(regexp = "[0-9]+")
	@Column(name= "dniCliente",nullable=false,length=8)
	private String dniCliente ;
	
	@Column(name= "nameCliente",nullable=false,length=20)
	private String nombreCliente;
	
	@Column(name= "apellidoCliente",nullable=false,length=20)
	private String apellidoCliente;
	
	@Size(min = 7, max=9)
	@Pattern(regexp ="[0-9]+")
	@Column(name= "telefonoCliente",nullable=false,length=9)
	private String telefonoCliente ;
	
	@Column(name= "nombreUniCliente",nullable=false,length=30)
	private String nombreUniCliente;
	
	@Column(name= "carreraUniCliente",nullable=false,length=30)
	private String carreraUniCliente;

	public Cliente() {
		super();
		
	}

	public Cliente(int idCliente, String correoCliente, String contraseñaCliente,
			@Size(min = 8, max = 8) @Pattern(regexp = "[0-9]+") String dniCliente, String nombreCliente,
			String apellidoCliente, @Size(min = 7, max = 9) @Pattern(regexp = "[0-9]+") String telefonoCliente,
			String nombreUniCliente, String carreraUniCliente) {
		super();
		this.idCliente = idCliente;
		this.correoCliente = correoCliente;
		this.contraseñaCliente = contraseñaCliente;
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.telefonoCliente = telefonoCliente;
		this.nombreUniCliente = nombreUniCliente;
		this.carreraUniCliente = carreraUniCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getContraseñaCliente() {
		return contraseñaCliente;
	}

	public void setContraseñaCliente(String contraseñaCliente) {
		this.contraseñaCliente = contraseñaCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getNombreUniCliente() {
		return nombreUniCliente;
	}

	public void setNombreUniCliente(String nombreUniCliente) {
		this.nombreUniCliente = nombreUniCliente;
	}

	public String getCarreraUniCliente() {
		return carreraUniCliente;
	}

	public void setCarreraUniCliente(String carreraUniCliente) {
		this.carreraUniCliente = carreraUniCliente;
	}



	
	
}
