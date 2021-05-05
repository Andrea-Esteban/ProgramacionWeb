package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IRese�aTutorDao;
import pe.edu.upc.entity.Rese�aTutor;
import pe.edu.upc.service.IRese�aTutorService;

@Named
@RequestScoped

public class Rese�aTutorServiceImpl implements IRese�aTutorService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IRese�aTutorDao mD;
	
	@Override
	public void insertar(Rese�aTutor rese�atutor) {
		mD.insertar(rese�atutor);
	}

	@Override
	public List<Rese�aTutor> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idRese�aTutor) {
		mD.eliminar(idRese�aTutor);		
	}

}
