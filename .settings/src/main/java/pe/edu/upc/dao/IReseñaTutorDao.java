package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Rese�aTutor;

public interface IRese�aTutorDao {
	public void insertar(Rese�aTutor rese�aTutor);
	public List<Rese�aTutor> listar();
	public void eliminar(int idRese�aTutor);
	
}
