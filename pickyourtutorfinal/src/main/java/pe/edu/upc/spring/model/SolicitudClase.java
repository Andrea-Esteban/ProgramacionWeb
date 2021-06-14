package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solicitudclase")
public class SolicitudClase implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idSolicitudClase;
	
	@ManyToOne
    @JoinColumn(name = "nombre_tutor", nullable = false)
    private Tutor tutor;

	@Column(name="dia_clase", nullable=false, length=50)
	private String diaClase;
	
	@Column(name="hora_clase", nullable=false, length=50)
	private String horaClase;
	
	
	@Column(name="fecha_clase", nullable=false, length=50)
	private String fechaClase;
	
	@Column(name="cantidad_de_hora_por_curso", nullable=false, length=50)
	private String horasCurso;
	
	@Column(name="link_clase", nullable=false, length=50)
	private String linkClase;

	@Column(name="estado_solicutud", nullable=false)
	private boolean estadoSolicitud;

	@OneToOne
	@JoinColumn(name="id_persona", nullable=false)
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name="idPago", nullable=false)
	private Pago pago;
	
	@OneToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	public SolicitudClase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudClase(int idSolicitudClase, Tutor tutor, String diaClase, String horaClase, String fechaClase,
			String horasCurso, String linkClase, boolean estadoSolicitud, Curso curso, Pago pago, Cliente cliente) {
		super();
		this.idSolicitudClase = idSolicitudClase;
		this.tutor = tutor;
		this.diaClase = diaClase;
		this.horaClase = horaClase;
		this.fechaClase = fechaClase;
		this.horasCurso = horasCurso;
		this.linkClase = linkClase;
		this.estadoSolicitud = estadoSolicitud;
		this.curso = curso;
		this.pago = pago;
		this.cliente = cliente;
	}

	public int getIdSolicitudClase() {
		return idSolicitudClase;
	}

	public void setIdSolicitudClase(int idSolicitudClase) {
		this.idSolicitudClase = idSolicitudClase;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getDiaClase() {
		return diaClase;
	}

	public void setDiaClase(String diaClase) {
		this.diaClase = diaClase;
	}

	public String getHoraClase() {
		return horaClase;
	}

	public void setHoraClase(String horaClase) {
		this.horaClase = horaClase;
	}

	public String getFechaClase() {
		return fechaClase;
	}

	public void setFechaClase(String fechaClase) {
		this.fechaClase = fechaClase;
	}

	public String getHorasCurso() {
		return horasCurso;
	}

	public void setHorasCurso(String horasCurso) {
		this.horasCurso = horasCurso;
	}

	public String getLinkClase() {
		return linkClase;
	}

	public void setLinkClase(String linkClase) {
		this.linkClase = linkClase;
	}

	public boolean isEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(boolean estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
