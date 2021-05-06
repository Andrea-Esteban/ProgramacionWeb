package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITutorDao;
import pe.edu.upc.entity.Tutor;

public class TutorDaoImpl implements ITutorDao, Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	
	@Transactional
	@Override
	public void insertar(Tutor tutor) {
		
		em.persist(tutor);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tutor> listar() {
		
		List<Tutor> lista= new ArrayList<Tutor>();
		Query q= em.createQuery("select m from Tutor m");
		lista = (List<Tutor>) q.getResultList();
		return lista;
		
	
	}

	@Transactional
	@Override
	public void eliminar(int idTutor) {
		
		Tutor tutor=new Tutor();
		tutor= em.getReference(Tutor.class, idTutor);
		em.remove(tutor);
		
	}

	
}


