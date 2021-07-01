package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "cursotutor")
public class CursoTutor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCursoTutor;
	
	@NotBlank(message = "Debe ingresar a la nota")
	@Pattern(regexp = "[0-9]+", message="La nota solo puede tener números")
	@Column(name="nota", nullable=false, length=2)
	private String nota;
	
	@Column(name="costoPorHora", nullable=false, length=3)
	private double costoHora;
	
	@NotBlank(message = "Debe ingresar el horaria disponible")
	@Column(name="horarioDisponible", nullable=false, length=90)
	private String horarioDisponible;

	@ManyToOne
	@JoinColumn(name = "idCurso", nullable = false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "idTutor", nullable = false)
	private Tutor tutor;

	public CursoTutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoTutor(int idCursoTutor,
			@NotBlank(message = "Debe ingresar a la nota") @Pattern(regexp = "[0-9]+", message = "La nota solo puede tener números") String nota,
			double costoHora,
			@NotBlank(message = "Debe ingresar el horaria disponible") String horarioDisponible, Curso curso,
			Tutor tutor) {
		super();
		this.idCursoTutor = idCursoTutor;
		this.nota = nota;
		this.costoHora = costoHora;
		this.horarioDisponible = horarioDisponible;
		this.curso = curso;
		this.tutor = tutor;
	}

	public int getIdCursoTutor() {
		return idCursoTutor;
	}

	public void setIdCursoTutor(int idCursoTutor) {
		this.idCursoTutor = idCursoTutor;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public double getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(double costoHora) {
		this.costoHora = costoHora;
	}

	public String getHorarioDisponible() {
		return horarioDisponible;
	}

	public void setHorarioDisponible(String horarioDisponible) {
		this.horarioDisponible = horarioDisponible;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	
	

}
