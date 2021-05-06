package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Solicitud;

public interface ISolicitudDao {
	public void insertar (Solicitud solicitud);
	public List<Solicitud> listar();
	public void eliminar(int idSolicitud);
	
	
}
