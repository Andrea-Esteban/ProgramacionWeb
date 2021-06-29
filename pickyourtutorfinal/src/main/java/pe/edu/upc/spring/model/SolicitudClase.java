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
@Table(name = "solicitudclase")
public class SolicitudClase implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idSolicitudClase;
    
    
    @Column(name="dia_clase", nullable=false, length=50)
    private String diaClase;
    
    @Column(name="hora_clase", nullable=false, length=50)
    private String horaClase;
    

    @Column(name="fecha_clase", nullable=false, length=50)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaClase;
    
    @Column(name="cantidad_de_hora_por_curso", nullable=false, length=50)
    private String horasCurso;

    @ManyToOne
    @JoinColumn(name="idCursoTutor", nullable=false)
    private CursoTutor cursoTutor;
    

    public SolicitudClase() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SolicitudClase(int idSolicitudClase, String diaClase, String horaClase, Date fechaClase, String horasCurso,
            CursoTutor cursoTutor, Tutor tutor) {
        super();
        this.idSolicitudClase = idSolicitudClase;
        this.diaClase = diaClase;
        this.horaClase = horaClase;
        this.fechaClase = fechaClase;
        this.horasCurso = horasCurso;
        this.cursoTutor = cursoTutor;
    }

    public int getIdSolicitudClase() {
        return idSolicitudClase;
    }

    public void setIdSolicitudClase(int idSolicitudClase) {
        this.idSolicitudClase = idSolicitudClase;
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

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getHorasCurso() {
        return horasCurso;
    }

    public void setHorasCurso(String horasCurso) {
        this.horasCurso = horasCurso;
    }

    public CursoTutor getCursoTutor() {
        return cursoTutor;
    }

    public void setCursoTutor(CursoTutor cursoTutor) {
        this.cursoTutor = cursoTutor;
    }


}
