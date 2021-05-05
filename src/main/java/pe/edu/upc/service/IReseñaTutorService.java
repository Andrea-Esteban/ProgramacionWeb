package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.ReseņaTutor;

public interface IReseņaTutorService {
	public void insertar(ReseņaTutor reseņatutor);
	public List<ReseņaTutor> listar();
	public void eliminar(int idReseņaTutor);	
}
