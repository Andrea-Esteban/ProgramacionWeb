
package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.SolicitudClase;

public interface ISolicitudClaseService {

	public boolean insertar (SolicitudClase solicitudclase);
	public boolean modificar(SolicitudClase solicitudclase);
	public void eliminar(int idSolicitudClase);
	public Optional<SolicitudClase> listarId(int idSolicitudClase);
	List<SolicitudClase> listar();
	List<SolicitudClase> listarNombreTutor(String nombre);
	List<SolicitudClase> listarNombreCurso(String nombreCurso);
	
}
