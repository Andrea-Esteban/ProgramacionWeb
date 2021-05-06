package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.ReseñaTutor;

public interface IReseñaTutorDao {
	public void insertar(ReseñaTutor reseñaTutor);
	public List<ReseñaTutor> listar();
	public void eliminar(int idReseñaTutor);
	
}
