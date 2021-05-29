package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tutor")
public class Pago implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTutor;

	@Column(name="Monto", nullable=false, length=50)
	private String monto;

	@Column(name="Fecha", nullable=false, length=50)
	private Date fecha;

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(int idTutor, String monto, Date fecha) {
		super();
		this.idTutor = idTutor;
		this.monto = monto;
		this.fecha = fecha;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
