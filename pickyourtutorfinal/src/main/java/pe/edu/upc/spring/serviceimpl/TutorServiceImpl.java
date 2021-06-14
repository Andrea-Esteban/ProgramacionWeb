package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Tutor;
import pe.edu.upc.spring.repository.ITutorRepository;
import pe.edu.upc.spring.service.ITutorService;

@Service
public class TutorServiceImpl implements ITutorService {

	@Autowired
	private ITutorRepository dTutor;

	@Override
	@Transactional
	public boolean insertar(Tutor tutor) {
		Tutor objTutor = dTutor.save(tutor);
		if (objTutor == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Tutor tutor) {
		boolean flag = false;
		try {
			dTutor.save(tutor);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idTutor) {
		dTutor.deleteById(idTutor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tutor> listarId(int idTutor) {
		return dTutor.findById(idTutor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tutor> listar() {
		return dTutor.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tutor> buscarNombre(String nombre) {
		return dTutor.buscarNombre(nombre);
	}
}
