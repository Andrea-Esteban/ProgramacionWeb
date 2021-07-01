package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pago")
public class Pago implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPago;


	@Column(name="fecha", nullable=false, length=50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@NotBlank(message = "Debe ingresar el número de Tarjeta")
	@Pattern(regexp = "[0-9]+", message="El teléfono solo puede tener números")
	@Size(min = 16, max = 16, message = "El número de la tarjeta solo debe tener 16 digitos")
	@Column(name="numero_tarjeta", nullable=false, length=16)
	private String numeroTarj;

	@NotBlank(message = "Debe ingresar el número de caducidad")
	@Size(min = 4, max = 4, message = "La fecha de caducidad solo debe tener 4 digitos")
	@Pattern(regexp = "[0-9]+", message="El teléfono solo puede tener números")
	@Column(name="caducidad", nullable=false, length=4)
	private String caducidad;
	
	@NotBlank(message = "Debe ingresar el nombre del titular")
	@Pattern(regexp = "[A-Za-zñ ]+", message="El nombre solo puede tener letras")
	@Column(name="nombre_titular", nullable=false, length=50)
	private String nombreTitular;
	
	@Pattern(regexp = "[0-9]+", message="El codigo de Seguridad solo puede tener números")
	@Size(min = 3, max = 3, message = "El código Seguridad solo debe tener 3 digitos")
	@Column(name="codigo_seguridad", nullable=false, length=3)
	private String codigoSeguridad;	
	
	@ManyToOne
	@JoinColumn(name="idMetodo", nullable=false)
	private MetodoPago metodoPago;
	
	@ManyToOne
	@JoinColumn(name="idSolicitudClase", nullable=false)
	private SolicitudClase solicitudClase;
	
	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(int idPago, Date fecha,
			@NotBlank(message = "Debe ingresar el número de Tarjeta") @Pattern(regexp = "[0-9]+", message = "El teléfono solo puede tener números") String numeroTarj,
			@NotBlank(message = "Debe ingresar el número de caducidad") @Size(min = 4, max = 4, message = "La fecha de caducidad solo debe tener 4 digitos") @Pattern(regexp = "[0-9]+", message = "El teléfono solo puede tener números") String caducidad,
			@NotBlank(message = "Debe ingresar el nombre del titular") @Pattern(regexp = "[A-Za-zñ ]+", message = "El nombre solo puede tener letras") String nombreTitular,
			@Pattern(regexp = "[0-9]+", message = "El codigo de Seguridad solo puede tener números") @Size(min = 3, max = 3, message = "El código Seguridad solo debe tener 3 digitos") String codigoSeguridad,
			MetodoPago metodoPago, SolicitudClase solicitudClase) {
		super();
		this.idPago = idPago;
		this.fecha = fecha;
		this.numeroTarj = numeroTarj;
		this.caducidad = caducidad;
		this.nombreTitular = nombreTitular;
		this.codigoSeguridad = codigoSeguridad;
		this.metodoPago = metodoPago;
		this.solicitudClase = solicitudClase;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumeroTarj() {
		return numeroTarj;
	}

	public void setNumeroTarj(String numeroTarj) {
		this.numeroTarj = numeroTarj;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public SolicitudClase getSolicitudClase() {
		return solicitudClase;
	}

	public void setSolicitudClase(SolicitudClase solicitudClase) {
		this.solicitudClase = solicitudClase;
	}


}
