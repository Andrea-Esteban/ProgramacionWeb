package pe.edu.upc.service;

import java.util.List;


import pe.edu.upc.entity.Tutor;

public interface ITutorService {
	public void insertar(Tutor tutor);
	public List<Tutor>listar();
	public void eliminar (int idTutor);
	public List<Tutor> findByTutor(Tutor c);


}
