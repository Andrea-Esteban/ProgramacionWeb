package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.ResenaTutor;


public interface IResenaTutorService {

	public boolean insertar (ResenaTutor resenatutor);
	public boolean modificar(ResenaTutor resenatutor);
	public void eliminar(int idReseña);
	public Optional<ResenaTutor> listarId(int idReseña);
	List<ResenaTutor> listar();
	List<ResenaTutor> buscarNombre(int valoracion);
	
}
