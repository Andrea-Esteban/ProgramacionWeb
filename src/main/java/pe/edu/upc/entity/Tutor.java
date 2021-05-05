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
@Table(name="tutor")
public class Tutor implements Serializable {


	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int idTutor;
	
	@Column(name= "correoTutor",nullable=false,length=50)
	private String correoTutor;
	
	@Column(name= "contraseñaTutor",nullable=false,length=50)
	private String contraseñaTutor ;
	
	@Size(min = 8, max=8)
	@Pattern(regexp = "[0-9]+")
	@Column(name= "dniTutor",nullable=false,length=8)
	private String dniTutor ;
	
	@Column(name= "nameTutor",nullable=false,length=20)
	private String nombreTutor;
	
	@Column(name= "apellidoTutor",nullable=false,length=20)
	private String apellidoTutor;
	
	@Size(min = 7, max=9)
	@Pattern(regexp = "[0-9]+")
	@Column(name= "telefonoTutor",nullable=false,length=9)
	private String telefonoTutor ;
	
	@Column(name= "nombreUniTutor",nullable=false,length=30)
	private String nombreUniTutor;
	
	@Column(name= "carreraUniTutor",nullable=false,length=30)
	private String carreraUniTutor;

	public Tutor() {
		super();
		
	}

	public Tutor(int idTutor, String correoTutor, String contraseñaTutor,
			@Size(min = 8, max = 8) @Pattern(regexp = "[0-9]+") String dniTutor, String nombreTutor,
			String apellidoTutor, @Size(min = 7, max = 9) @Pattern(regexp = "[0-9]+") String telefonoTutor,
			String nombreUniTutor, String carreraUniTutor) {
		super();
		this.idTutor = idTutor;
		this.correoTutor = correoTutor;
		this.contraseñaTutor = contraseñaTutor;
		this.dniTutor = dniTutor;
		this.nombreTutor = nombreTutor;
		this.apellidoTutor = apellidoTutor;
		this.telefonoTutor = telefonoTutor;
		this.nombreUniTutor = nombreUniTutor;
		this.carreraUniTutor = carreraUniTutor;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public String getCorreoTutor() {
		return correoTutor;
	}

	public void setCorreoTutor(String correoTutor) {
		this.correoTutor = correoTutor;
	}

	public String getContraseñaTutor() {
		return contraseñaTutor;
	}

	public void setContraseñaTutor(String contraseñaTutor) {
		this.contraseñaTutor = contraseñaTutor;
	}

	public String getDniTutor() {
		return dniTutor;
	}

	public void setDniTutor(String dniTutor) {
		this.dniTutor = dniTutor;
	}

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}

	public String getApellidoTutor() {
		return apellidoTutor;
	}

	public void setApellidoTutor(String apellidoTutor) {
		this.apellidoTutor = apellidoTutor;
	}

	public String getTelefonoTutor() {
		return telefonoTutor;
	}

	public void setTelefonoTutor(String telefonoTutor) {
		this.telefonoTutor = telefonoTutor;
	}

	public String getNombreUniTutor() {
		return nombreUniTutor;
	}

	public void setNombreUniTutor(String nombreUniTutor) {
		this.nombreUniTutor = nombreUniTutor;
	}

	public String getCarreraUniTutor() {
		return carreraUniTutor;
	}

	public void setCarreraUniTutor(String carreraUniTutor) {
		this.carreraUniTutor = carreraUniTutor;
	}


	
}
