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
@Table(name = "metodopago")

public class MetodoPago implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idMetodo;
	
	@Column(name= "nombre", nullable= false, length=50)
	private String nombre;
	
	@Column(name= "id_clase", nullable= false, length= 50)
	private int id_Clase;
	
	@OneToOne
	@JoinColumn(name="idPago", nullable=false)
	private Pago pago;
	
	public MetodoPago() {
		super();
	}

	public MetodoPago(int idMetodo, String nombre, int id_Clase, Pago pago) {
		super();
		this.idMetodo = idMetodo;
		this.nombre = nombre;
		this.id_Clase = id_Clase;
		this.pago = pago;
	}

	public int getIdMetodo() {
		return idMetodo;
	}

	public void setIdMetodo(int idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_Clase() {
		return id_Clase;
	}

	public void setId_Clase(int id_Clase) {
		this.id_Clase = id_Clase;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
	
}
