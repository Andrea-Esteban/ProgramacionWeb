package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.CursoTutor;

public interface ICursoTutorService {
	public void insertar(CursoTutor cursotutor);
	public List<CursoTutor> listar();
	public void eliminar(int idCursoTutor);	
}
