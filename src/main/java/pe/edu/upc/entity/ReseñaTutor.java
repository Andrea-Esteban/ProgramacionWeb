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
public class ReseñaTutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idReseñaTutor;
	
	@NotBlank(message = "Debe Ingresar un número del 1 al 5")
	@Size(min = 1, max = 1, message = "La valoracion máxima es 5")
	@Pattern(regexp = "[0-6]+", message="La valoracion solo puede tener números")
	@Column(name = "valoracion", length = 1,  nullable = false)
	private int valoracion;

	@ManyToOne
	@JoinColumn(name="idTutor", nullable=false)
	private Tutor tutor;

	public ReseñaTutor() {
		super();
	}

	public ReseñaTutor(int idReseñaTutor,
			@NotBlank(message = "Debe Ingresar un número del 1 al 5") @Size(min = 1, max = 1, message = "La valoracion máxima es 5") @Pattern(regexp = "[0-6]+", message = "La valoracion solo puede tener números") int valoracion,
			Tutor tutor) {
		super();
		this.idReseñaTutor = idReseñaTutor;
		this.valoracion = valoracion;
		this.tutor = tutor;
	}

	public int getIdReseñaTutor() {
		return idReseñaTutor;
	}

	public void setIdReseñaTutor(int idReseñaTutor) {
		this.idReseñaTutor = idReseñaTutor;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}



}
