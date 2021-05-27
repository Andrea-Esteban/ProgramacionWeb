package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Tutor;

public interface ITutorService {

	public boolean insertar (Tutor tutor);
	public boolean modificar(Tutor tutor);
	public void eliminar(int idTutor);
	public Optional<Tutor> listarId(int idTutor);
	List<Tutor> listar();
	List<Tutor> buscarNombre(String nombre);
}
