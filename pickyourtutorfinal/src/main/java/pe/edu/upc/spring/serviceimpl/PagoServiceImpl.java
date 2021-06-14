package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Pago;
import pe.edu.upc.spring.repository.IPagoRepository;
import pe.edu.upc.spring.service.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService {

	@Autowired
	private IPagoRepository dPago;

	@Override
	@Transactional
	public boolean insertar(Pago pago) {
		Pago objPago = dPago.save(pago);
		if (objPago == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Pago pago) {
		boolean flag = false;
		try {
			dPago.save(pago);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPago) {
		dPago.deleteById(idPago);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pago> listarId(int idPago) {
		return dPago.findById(idPago);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pago> listar() {
		return dPago.findAll();
	}

}
