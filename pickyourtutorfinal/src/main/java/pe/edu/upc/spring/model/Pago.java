package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Date fecha;
	
	@Column(name="numero_tarjeta", nullable=false, length=16)
	private int numero_tarj;

	@Column(name="caducidad", nullable=false, length=4)
	private int caducidad;
	
	@Column(name="nombre_titular", nullable=false, length=50)
	private String nombre_titular;
	
	@Column(name="codigo_seguridad", nullable=false, length=3)
	private int codigo_seguridad;	
	
	@OneToOne
	@JoinColumn(name="idMetodo", nullable=false)
	private MetodoPago metodoPago;
	
	@OneToOne
	@JoinColumn(name="idSolicitudClase", nullable=false)
	private SolicitudClase solicitudClase;
	
	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(int idPago, String monto, Date fecha, int numero_tarj, int caducidad, String nombre_titular,
			int codigo_seguridad, MetodoPago metodoPago, SolicitudClase solicitudClase) {
		super();
		this.idPago = idPago;
		this.monto = monto;
		this.fecha = fecha;
		this.numero_tarj = numero_tarj;
		this.caducidad = caducidad;
		this.nombre_titular = nombre_titular;
		this.codigo_seguridad = codigo_seguridad;
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

	public int getNumero_tarj() {
		return numero_tarj;
	}

	public void setNumero_tarj(int numero_tarj) {
		this.numero_tarj = numero_tarj;
	}

	public int getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(int caducidad) {
		this.caducidad = caducidad;
	}

	public String getNombre_titular() {
		return nombre_titular;
	}

	public void setNombre_titular(String nombre_titular) {
		this.nombre_titular = nombre_titular;
	}

	public int getCodigo_seguridad() {
		return codigo_seguridad;
	}

	public void setCodigo_seguridad(int codigo_seguridad) {
		this.codigo_seguridad = codigo_seguridad;
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
