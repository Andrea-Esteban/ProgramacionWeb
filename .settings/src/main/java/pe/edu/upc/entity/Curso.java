package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCurso;
	
	@NotBlank(message = "Debe Ingresar un nombre al curso")
	@Pattern(regexp = "[A-Z0-9a-z]+", message="El nombre del curso solo puede tener letras o números")
	@Column(name = "nombre_curso", length = 25,  nullable = false)
	private String nombreCurso;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int idCurso,String nombreCurso) {
		super();
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	

}