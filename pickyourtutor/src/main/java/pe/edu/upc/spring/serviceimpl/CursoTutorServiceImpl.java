package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.CursoTutor;
import pe.edu.upc.spring.repository.ICursoTutorRepository;
import pe.edu.upc.spring.service.ICursoTutorService;

@Service
public class CursoTutorServiceImpl implements ICursoTutorService {

	@Autowired
	private ICursoTutorRepository dCursoTutor;

	@Override
	@Transactional
	public boolean insertar(CursoTutor cursotutor) {
		CursoTutor objCurso = dCursoTutor.save(cursotutor);
		if (objCurso == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(CursoTutor cursotutor) {
		boolean flag = false;
		try {
			dCursoTutor.save(cursotutor);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idCursoTutor) {
		dCursoTutor.deleteById(idCursoTutor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CursoTutor> listarId(int idCursoTutor) {
		return dCursoTutor.findById(idCursoTutor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CursoTutor> listar() {
		return dCursoTutor.findAll();
	}

	
}
