package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.repository.IClienteRepository;
import pe.edu.upc.spring.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository dCliente;

	@Override
	@Transactional
	public boolean insertar(Cliente cliente) {
		Cliente objCliente = dCliente.save(cliente);
		if (objCliente == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Cliente cliente) {
		boolean flag = false;
		try {
			dCliente.save(cliente);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idCliente) {
		dCliente.deleteById(idCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> listarId(int idCliente) {
		return dCliente.findById(idCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listar() {
		return dCliente.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarNombre(String nombre) {
		return dCliente.buscarNombre(nombre);
	}


}
