package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SolicitudClase;
import pe.edu.upc.spring.repository.ISolicitudClaseRepository;
import pe.edu.upc.spring.service.ISolicitudClaseService;

@Service
public class SolicitudClaseServiceImpl implements ISolicitudClaseService {

	@Autowired
	private ISolicitudClaseRepository dSolicitudClase;

	@Override
	@Transactional
	public boolean insertar(SolicitudClase solicitudclase) {
		SolicitudClase objSolicitudClase = dSolicitudClase.save(solicitudclase);
		if (objSolicitudClase == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(SolicitudClase solicitudclase) {
		boolean flag = false;
		try {
			dSolicitudClase.save(solicitudclase);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idSolicitudClase) {
		dSolicitudClase.deleteById(idSolicitudClase);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<SolicitudClase> listarId(int idSolicitudClase) {
		return dSolicitudClase.findById(idSolicitudClase);
	}

	@Override
	public List<SolicitudClase> listar(){
		List<SolicitudClase> lista = dSolicitudClase.findAll();
		return lista;
	}


	@Override
	@Transactional(readOnly = true)
	public List<SolicitudClase> buscarNombreTutor(String nombre) {
		return dSolicitudClase.buscarNombreTutor(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SolicitudClase> buscarNombreCurso(String nombreCurso) {
		return dSolicitudClase.buscarNombreCurso(nombreCurso);
	}

	
}
