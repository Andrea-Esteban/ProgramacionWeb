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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pago")
public class Pago implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPago;

	@Column(name="monto", nullable=false, length=50)
	private String monto;

	@Column(name="fecha", nullable=false, length=50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(name="numero_tarjeta", nullable=false, length=16)
	private String numeroTarj;

	@Column(name="caducidad", nullable=false, length=4)
	private int caducidad;
	
	@Column(name="nombre_titular", nullable=false, length=50)
	private String nombreTitular;
	
	@Column(name="codigo_seguridad", nullable=false, length=3)
	private int codigoSeguridad;	
	
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

	public Pago(int idPago, String monto, Date fecha, String numeroTarj, int caducidad, String nombreTitular,
			int codigoSeguridad, MetodoPago metodoPago, SolicitudClase solicitudClase) {
		super();
		this.idPago = idPago;
		this.monto = monto;
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

	public String getNumeroTarj() {
		return numeroTarj;
	}

	public void setNumeroTarj(String numeroTarj) {
		this.numeroTarj = numeroTarj;
	}

	public int getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(int caducidad) {
		this.caducidad = caducidad;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
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
