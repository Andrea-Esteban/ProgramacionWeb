package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Solicitud")

public class Solicitud implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idSolicitud;

	@Column(name="diaClase", nullable=false, length=30)
	private String diaClase;
	private int horaClase;
	private Date fechaClase;
	private int cantHoraCurso;
	private String linkCurso;
	private boolean EstadoSolicitud;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCurso;

	public Solicitud() {
		super();
		
	}

	public Solicitud(int idSolicitud, String diaClase, int horaClase, Date fechaClase, int cantHoraCurso,
			String linkCurso, boolean estadoSolicitud, int idCurso) {
		super();
		this.idSolicitud = idSolicitud;
		this.diaClase = diaClase;
		this.horaClase = horaClase;
		this.fechaClase = fechaClase;
		this.cantHoraCurso = cantHoraCurso;
		this.linkCurso = linkCurso;
		EstadoSolicitud = estadoSolicitud;
		this.idCurso = idCurso;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getDiaClase() {
		return diaClase;
	}

	public void setDiaClase(String diaClase) {
		this.diaClase = diaClase;
	}

	public int getHoraClase() {
		return horaClase;
	}

	public void setHoraClase(int horaClase) {
		this.horaClase = horaClase;
	}

	public Date getFechaClase() {
		return fechaClase;
	}

	public void setFechaClase(Date fechaClase) {
		this.fechaClase = fechaClase;
	}

	public int getCantHoraCurso() {
		return cantHoraCurso;
	}

	public void setCantHoraCurso(int cantHoraCurso) {
		this.cantHoraCurso = cantHoraCurso;
	}

	public String getLinkCurso() {
		return linkCurso;
	}

	public void setLinkCurso(String linkCurso) {
		this.linkCurso = linkCurso;
	}

	public boolean isEstadoSolicitud() {
		return EstadoSolicitud;
	}

	public void setEstadoSolicitud(boolean estadoSolicitud) {
		EstadoSolicitud = estadoSolicitud;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	 
	

	
	
	
	





	
	
	
	
	
	
	
}
