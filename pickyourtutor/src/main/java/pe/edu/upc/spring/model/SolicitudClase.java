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
@Table(name = "SolicitudClase")
public class SolicitudClase implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idSolicitudClase;
	
	@ManyToOne
    @JoinColumn(name = "nombre_tutor", nullable = false)
    private Tutor tutor;
	
	@OneToOne
    @JoinColumn(name = "id_Curso", nullable = false)
    private Curso curso;

	@Column(name="Dia Clase", nullable=false, length=50)
	private String diaClase;
	
	@Column(name="Hora Clase", nullable=false, length=50)
	private String horaClase;
	
	
	@Column(name="Fecha Clase", nullable=false, length=50)
	private String fechaClase;
	
	@Column(name="Cantidad de hora por Curso", nullable=false, length=50)
	private String horasCurso;
	
	@Column(name="Link Clase", nullable=false, length=50)
	private String linkClase;

	@Column(name="Estado  Solicutud", nullable=false, length=50)
	private boolean estadoSolicitud;

	public SolicitudClase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudClase(int idSolicitudClase, Tutor tutor, Curso curso, String diaClase, String horaClase,
			String fechaClase, String horasCurso, String linkClase, boolean estadoSolicitud) {
		super();
		this.idSolicitudClase = idSolicitudClase;
		this.tutor = tutor;
		this.curso = curso;
		this.diaClase = diaClase;
		this.horaClase = horaClase;
		this.fechaClase = fechaClase;
		this.horasCurso = horasCurso;
		this.linkClase = linkClase;
		this.estadoSolicitud = estadoSolicitud;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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

	


	
}
