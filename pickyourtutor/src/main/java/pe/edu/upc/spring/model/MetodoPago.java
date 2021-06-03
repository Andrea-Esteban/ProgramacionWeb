package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public MetodoPago() {
		super();
	}

	public MetodoPago(int idMetodo, String nombre, int id_Clase) {
		super();
		this.idMetodo = idMetodo;
		this.nombre = nombre;
		this.id_Clase = id_Clase;
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


	
	
	
	
	
	
	
	
	
	
	
	
	
}
