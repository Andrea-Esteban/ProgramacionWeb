package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRese�aTutorDao;
import pe.edu.upc.entity.Rese�aTutor;

public class Rese�aTutorDaoImpl implements IRese�aTutorDao, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Rese�aTutor rese�atutor) {
		em.persist(rese�atutor);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rese�aTutor> listar() {
		List<Rese�aTutor> lista = new ArrayList<Rese�aTutor>();
		Query q = em.createQuery("select rt from Rese�aTutor rt");
		lista = (List<Rese�aTutor>) q.getResultList();
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idRese�aTutor) {
		Rese�aTutor rese�atutor = new Rese�aTutor();
		rese�atutor= em.getReference(Rese�aTutor.class, idRese�aTutor);
		em.remove(rese�atutor);		
	}
}
