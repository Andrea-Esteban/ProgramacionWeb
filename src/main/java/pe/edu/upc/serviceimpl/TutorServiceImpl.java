package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITutorDao;
import pe.edu.upc.entity.Tutor;
import pe.edu.upc.service.ITutorService;

public class TutorServiceImpl implements ITutorService, Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITutorDao mT;

	@Override
	public void insertar(Tutor tutor) {
		mT.insertar(tutor);
		
	}

	@Override
	public List<Tutor> listar() {
		
		return mT.listar();
	}

	@Override
	public void eliminar(int idTutor) {
		mT.eliminar(idTutor);
		
	}
	
	

}
