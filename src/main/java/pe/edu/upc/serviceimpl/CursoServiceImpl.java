package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICursoDao;
import pe.edu.upc.entity.Curso;
import pe.edu.upc.service.ICursoService;

@Named
@RequestScoped

public class CursoServiceImpl implements ICursoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICursoDao mD;
	
	@Override
	public void insertar(Curso curso) {
		mD.insertar(curso);
	}

	@Override
	public List<Curso> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idCurso) {
		mD.eliminar(idCurso);		
	}

}
