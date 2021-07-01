package pe.edu.upc.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.SolicitudClase;


@Repository
public interface ISolicitudClaseRepository extends JpaRepository<SolicitudClase, Integer> {

	
	@Query("From SolicitudClase s where s.cursoTutor.tutor.nombre like %:nombre%")
	List<SolicitudClase> buscarNombreTutor(@Param("nombre") String nombre);
	
	@Query("From SolicitudClase s where s.cursoTutor.curso.nombreCurso like %:nombreCurso%")
	List<SolicitudClase> buscarNombreCurso(@Param("nombreCurso") String nombreCurso);
	
}