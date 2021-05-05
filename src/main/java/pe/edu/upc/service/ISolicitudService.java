package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Solicitud;

public interface ISolicitudService {
	
	public void insertar (Solicitud solicitud);
	public List<Solicitud> listar();
	public void eliminar(int idSolicitud);

}
