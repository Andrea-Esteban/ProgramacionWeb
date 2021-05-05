package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Curso;

public interface ICursoDao {
	public void insertar(Curso curso);
	public List<Curso> listar();
	public void eliminar(int idCurso);
	
}
