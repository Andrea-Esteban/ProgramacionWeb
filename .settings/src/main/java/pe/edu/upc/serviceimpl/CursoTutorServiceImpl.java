package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICursoTutorDao;
import pe.edu.upc.entity.CursoTutor;
import pe.edu.upc.service.ICursoTutorService;

@Named
@RequestScoped

public class CursoTutorServiceImpl implements ICursoTutorService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICursoTutorDao mD;
	
	@Override
	public void insertar(CursoTutor cursotutor) {
		mD.insertar(cursotutor);
	}

	@Override
	public List<CursoTutor> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idCursoTutor) {
		mD.eliminar(idCursoTutor);		
	}

}
