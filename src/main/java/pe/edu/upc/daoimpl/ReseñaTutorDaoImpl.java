package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IReseñaTutorDao;
import pe.edu.upc.entity.ReseñaTutor;

public class ReseñaTutorDaoImpl implements IReseñaTutorDao, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(ReseñaTutor reseñatutor) {
		em.persist(reseñatutor);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReseñaTutor> listar() {
		List<ReseñaTutor> lista = new ArrayList<ReseñaTutor>();
		Query q = em.createQuery("select rt from ReseñaTutor rt");
		lista = (List<ReseñaTutor>) q.getResultList();
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idReseñaTutor) {
		ReseñaTutor reseñatutor = new ReseñaTutor();
		reseñatutor= em.getReference(ReseñaTutor.class, idReseñaTutor);
		em.remove(reseñatutor);		
	}
}
