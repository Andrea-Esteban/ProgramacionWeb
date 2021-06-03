package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "reseñaTutor")
public class ResenaTutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int idReseña;
	
	@Column(name= "valoracion", nullable= false, length= 10)
	private int valoracion;
	
	@Column(name= "idTutor", nullable= false, length= 10)
	private int id_Tutor;

	public ResenaTutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResenaTutor(int idReseña, int valoracion, int id_Tutor) {
		super();
		this.idReseña = idReseña;
		this.valoracion = valoracion;
		this.id_Tutor = id_Tutor;
	}

	public int getIdReseña() {
		return idReseña;
	}

	public void setIdReseña(int idReseña) {
		this.idReseña = idReseña;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getId_Tutor() {
		return id_Tutor;
	}

	public void setId_Tutor(int id_Tutor) {
		this.id_Tutor = id_Tutor;
	}
	
	
	
	
	
	
}
