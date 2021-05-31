package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.ResenaTutor;
import pe.edu.upc.spring.repository.IResenaTutorRepository;
import pe.edu.upc.spring.service.IResenaTutorService;

@Service
public class ResenaTutorImpl implements IResenaTutorService {
	@Autowired
	private IResenaTutorRepository dResena;

	@Override
	@Transactional
	public boolean insertar(ResenaTutor resenatutor) {
		ResenaTutor objResenaTutor = dResena.save(resenatutor);
		if (objResenaTutor == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(ResenaTutor resenatutor) {
		boolean flag = false;
		try {
			dResena.save(resenatutor);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReseña) {
		dResena.deleteById(idReseña);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ResenaTutor> listarId(int idReseña) {
		return dResena.findById(idReseña);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResenaTutor> listar() {
		return dResena.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResenaTutor> buscarNombre(int valoracion) {
		return dResena.buscarValoracion(valoracion);
	}
}
