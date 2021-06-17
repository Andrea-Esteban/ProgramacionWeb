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

@Entity
@Table(name = "cursotutor")
public class CursoTutor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCursoTutor;

	@Column(name="nota", nullable=false, length=2)
	private String nota;
	
	@Column(name="costoPorHora", nullable=false, length=3)
	private String costoHora;

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
	
	
	
	

	public CursoTutor(int idCursoTutor, String nota, String costoHora, Curso curso, Tutor tutor) {
		super();
		this.idCursoTutor = idCursoTutor;
		this.nota = nota;
		this.costoHora = costoHora;
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

	public String getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(String costoHora) {
		this.costoHora = costoHora;
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
