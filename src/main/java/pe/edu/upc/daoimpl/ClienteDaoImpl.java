package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IClienteDao;
import pe.edu.upc.entity.Cliente;

public class ClienteDaoImpl implements IClienteDao, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	
@Transactional
	@Override
	public void insertar(Cliente cliente) {
		em.persist(cliente);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		List<Cliente> lista= new ArrayList<Cliente>();
		Query q= em.createQuery("select m from Cliente m");
		lista = (List<Cliente>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idCliente) {
		
		Cliente cliente = new Cliente ();
		cliente =em.getReference(Cliente.class, idCliente);
		em.remove(cliente);
	}

}
