package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Rese�aTutor;

public interface IRese�aTutorService {
	public void insertar(Rese�aTutor rese�atutor);
	public List<Rese�aTutor> listar();
	public void eliminar(int idRese�aTutor);	
}
