package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCurso;

	@Column(name="nombre_curso", nullable=false, length=50)
	private String nombreCurso;

	@OneToOne
	@JoinColumn(name="idCursoTutor", nullable=false)
	private CursoTutor cursoTutor;
	
	@OneToOne
	@JoinColumn(name="idSolicitudClase", nullable=false)
	private SolicitudClase solicitudClase;
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int idCurso, String nombreCurso, CursoTutor cursoTutor, SolicitudClase solicitudClase) {
		super();
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.cursoTutor = cursoTutor;
		this.solicitudClase = solicitudClase;
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

	public CursoTutor getCursoTutor() {
		return cursoTutor;
	}

	public void setCursoTutor(CursoTutor cursoTutor) {
		this.cursoTutor = cursoTutor;
	}

	public SolicitudClase getSolicitudClase() {
		return solicitudClase;
	}

	public void setSolicitudClase(SolicitudClase solicitudClase) {
		this.solicitudClase = solicitudClase;
	}


	
}
