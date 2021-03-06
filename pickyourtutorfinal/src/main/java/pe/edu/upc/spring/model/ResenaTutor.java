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
	private int idResena;
	
	@Column(name= "valoracion", nullable= false, length= 10)
	private double valoracion;
	
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

	public ResenaTutor(int idResena, double valoracion, Cliente cliente, Tutor tutor) {
		super();
		this.idResena = idResena;
		this.valoracion = valoracion;
		this.cliente = cliente;
		this.tutor = tutor;
	}

	public int getIdResena() {
		return idResena;
	}

	public void setIdResena(int idResena) {
		this.idResena = idResena;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
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
