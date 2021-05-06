package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.ReseñaTutor;

public interface IReseñaTutorService {
	public void insertar(ReseñaTutor reseñatutor);
	public List<ReseñaTutor> listar();
	public void eliminar(int idReseñaTutor);	
}
