package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Solicitud;
import pe.edu.upc.service.ISolicitudService;

@Named
@RequestScoped

public class SolicitudController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ISolicitudService mService;
	private Solicitud solicitud;
	List<Solicitud> listSolicitud;
	
	@PostConstruct
	public void init() {
		this.listSolicitud = new ArrayList<Solicitud>();
		this.solicitud = new Solicitud();
		this.listar();
	}
	
	public String nuevaSolicitud() {
		this.setSolicitud(new Solicitud());
		return "motor.xhtml";
	}
	
	public void insertar() {
		mService.insertar(solicitud);
		limpiarSolicitud();
		
	}
	
	public void listar() {
		this.init();
	}
	
	public void limpiarSolicitud() {
		this.init();
		
	}
	
	public void eliminar(Solicitud solicitud) {
		mService.eliminar(solicitud.getIdSolicitud());
		this.listar();
	}
	
	

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<Solicitud> getListSolicitud() {
		return listSolicitud;
	}

	public void setListSolicitud(List<Solicitud> listSolicitud) {
		this.listSolicitud = listSolicitud;
	}
	
}
