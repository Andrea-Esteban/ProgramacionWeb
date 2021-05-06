package pe.edu.upc.dao;

import java.util.List;


import pe.edu.upc.entity.Tutor;

public interface ITutorDao {
	
	
	public void insertar(Tutor tutor);
	public List<Tutor>listar();
	public void eliminar (int idTutor);
	public List<Tutor> findByNameTutor(Tutor c);

}
