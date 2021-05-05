package pe.edu.upc.entity;

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
import javax.validation.constraints.Size;

@Entity
@Table(name="cursoTutor")
public class CursoTutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCursoTutor;
	
	@NotBlank(message = "Debe Ingresar su nota del curso")
	@Size(min = 2, max = 2, message = "La nota minima para poder enseñar es 16")
	@Pattern(regexp = "[0-9]+", message="El código del curso solo puede tener números")
	@Column(name = "nota_Curso", length = 2,  nullable = false)
	private int notaCurso;
	
	@NotBlank(message = "Debe Ingresar el precio de clase POR HORA")
	@Pattern(regexp = "[0-9]+", message="El precio solo puede tener números")
	@Column(name = "costo_hora", length = 2,  nullable = false)
	private int costo_hora;

	@ManyToOne
	@JoinColumn(name="idCurso", nullable=false)
	private Curso curso;

	public CursoTutor() {
		super();
	}

	public CursoTutor(int idCursoTutor,int notaCurso,int costo_hora,Curso curso) {
		super();
		this.idCursoTutor = idCursoTutor;
		this.notaCurso = notaCurso;
		this.costo_hora = costo_hora;
		this.curso = curso;
	}

	public int getIdCursoTutor() {
		return idCursoTutor;
	}

	public void setIdCursoTutor(int idCursoTutor) {
		this.idCursoTutor = idCursoTutor;
	}

	public int getNotaCurso() {
		return notaCurso;
	}

	public void setNotaCurso(int notaCurso) {
		this.notaCurso = notaCurso;
	}

	public int getCosto_hora() {
		return costo_hora;
	}

	public void setCosto_hora(int costo_hora) {
		this.costo_hora = costo_hora;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	

}
