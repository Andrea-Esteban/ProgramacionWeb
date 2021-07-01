package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "metodopago")

public class MetodoPago implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idMetodo;
	

	@NotBlank(message = "Debe ingresar su nombre")
	@Pattern(regexp = "[A-Za-zñ ]+", message="El nombre solo puede tener letras")
	@Column(name= "nombre", nullable= false, length=50)
	private String nombre;
	
	public MetodoPago() {
		super();
	}

	public MetodoPago(int idMetodo, String nombre) {
		super();
		this.idMetodo = idMetodo;
		this.nombre = nombre;
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

	
}
