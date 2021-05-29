package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.CursoTutor;

public interface ICursoTutorService {

	public boolean insertar (CursoTutor cursoTutor);
	public boolean modificar(CursoTutor cursoTutor);
	public void eliminar(int idCursoTutor);
	public Optional<CursoTutor> listarId(int idCursoTutor);
	List<CursoTutor> listar();
	
}