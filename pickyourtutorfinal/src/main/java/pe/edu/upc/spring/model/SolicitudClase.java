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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "solicitudclase")
public class SolicitudClase implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idSolicitudClase;
    
    @Column(name="fecha_clase", nullable=false, length=50)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaClase;
    
    
    @Column(name="cantidad_de_hora_por_curso", nullable=false, length=50)
    private int horasCurso;

	@Transient
	private double montoTotal;
    
    @ManyToOne
    @JoinColumn(name="idCursoTutor", nullable=false)
    private CursoTutor cursoTutor;
    

    public SolicitudClase() {
        super();
        // TODO Auto-generated constructor stub
    }


	public SolicitudClase(int idSolicitudClase, Date fechaClase, int horasCurso, double montoTotal,
			CursoTutor cursoTutor) {
		super();
		this.idSolicitudClase = idSolicitudClase;
		this.fechaClase = fechaClase;
		this.horasCurso = horasCurso;
		this.montoTotal = cursoTutor.getCostoHora()*horasCurso;
		this.cursoTutor = cursoTutor;
	}


	public int getIdSolicitudClase() {
		return idSolicitudClase;
	}


	public void setIdSolicitudClase(int idSolicitudClase) {
		this.idSolicitudClase = idSolicitudClase;
	}


	public Date getFechaClase() {
		return fechaClase;
	}


	public void setFechaClase(Date fechaClase) {
		this.fechaClase = fechaClase;
	}


	public int getHorasCurso() {
		return horasCurso;
	}


	public void setHorasCurso(int horasCurso) {
		this.horasCurso = horasCurso;
	}


	public double getMontoTotal() {
		return cursoTutor.getCostoHora()*horasCurso;
	}


	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}


	public CursoTutor getCursoTutor() {
		return cursoTutor;
	}


	public void setCursoTutor(CursoTutor cursoTutor) {
		this.cursoTutor = cursoTutor;
	}


	
}
