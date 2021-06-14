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
@Table(name = "resenaTutor")
public class ResenaTutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int idReseña;
	
	@Column(name= "valoracion", nullable= false, length= 10)
	private int valoracion;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idTutor", nullable = false)
	private Tutor tutor;

	public ResenaTutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResenaTutor(int idReseña, int valoracion, Cliente cliente, Tutor tutor) {
		super();
		this.idReseña = idReseña;
		this.valoracion = valoracion;
		this.cliente = cliente;
		this.tutor = tutor;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	
	
	
}
