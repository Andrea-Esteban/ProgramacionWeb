package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Curso;
import pe.edu.upc.spring.repository.ICursoRepository;
import pe.edu.upc.spring.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoRepository dCurso;

	@Override
	@Transactional
	public boolean insertar(Curso curso) {
		Curso objCurso = dCurso.save(curso);
		if (objCurso == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Curso curso) {
		boolean flag = false;
		try {
			dCurso.save(curso);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idCurso) {
		dCurso.deleteById(idCurso);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> listarId(int idCurso) {
		return dCurso.findById(idCurso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> listar() {
		return dCurso.findAll();
	}

	
}
