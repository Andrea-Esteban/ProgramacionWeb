package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICursoTutorDao;
import pe.edu.upc.entity.CursoTutor;

public class CursoTutorDaoImpl implements ICursoTutorDao, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(CursoTutor cursotutor) {
		em.persist(cursotutor);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CursoTutor> listar() {
		List<CursoTutor> lista = new ArrayList<CursoTutor>();
		Query q = em.createQuery("select ct from CursoTutor ct");
		lista = (List<CursoTutor>) q.getResultList();
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idCursoTutor) {
		CursoTutor cursotutor = new CursoTutor();
		cursotutor= em.getReference(CursoTutor.class, idCursoTutor);
		em.remove(cursotutor);		
	}
}
