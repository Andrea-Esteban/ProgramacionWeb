package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.CursoTutor;

public interface ICursoTutorDao {
	public void insertar(CursoTutor docenteCurso);
	public List<CursoTutor> listar();
	public void eliminar(int idCursoTutor);
	
}
