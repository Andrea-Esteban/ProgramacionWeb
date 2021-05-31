package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.MetodoPago;
import pe.edu.upc.spring.service.IMetodoPagoService;
import pe.edu.upc.spring.repository.IMetodoPagoRepository;

@Service
public class MetodoPagoServiceImpl implements IMetodoPagoService {

	@Autowired
	private IMetodoPagoRepository dMetodoPago;
	
	@Override
	@Transactional
	public boolean insertar(MetodoPago metodopago) {
		MetodoPago objMetodoPago = dMetodoPago.save(metodopago);
			if (objMetodoPago == null)
				return false;
			else
				return true;
	}
	
	@Override
	@Transactional
	public boolean modificar(MetodoPago metodopago) {
		boolean flag = false;
		try {
			dMetodoPago.save(metodopago);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idMetodoPago) {
		dMetodoPago.deleteById(idMetodoPago);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MetodoPago> listarId(int idMetodoPago) {
		return dMetodoPago.findById(idMetodoPago);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MetodoPago> listar() {
		return dMetodoPago.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<MetodoPago> buscarNombre(String nombre) {
		return dMetodoPago.buscarNombre(nombre);
	}
	
	
	
	
	
}
	