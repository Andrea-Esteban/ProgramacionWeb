package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IReseñaTutorDao;
import pe.edu.upc.entity.ReseñaTutor;
import pe.edu.upc.service.IReseñaTutorService;

@Named
@RequestScoped

public class ReseñaTutorServiceImpl implements IReseñaTutorService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IReseñaTutorDao mD;
	
	@Override
	public void insertar(ReseñaTutor reseñatutor) {
		mD.insertar(reseñatutor);
	}

	@Override
	public List<ReseñaTutor> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idReseñaTutor) {
		mD.eliminar(idReseñaTutor);		
	}

}
