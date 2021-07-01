package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Tutor;

@Repository
public interface ITutorRepository extends JpaRepository<Tutor, Integer> {

	@Query("From Tutor t where t.nombre like %:nombre%")
	List<Tutor> buscarNombre(@Param("nombre") String nombre);
	
	@Query("select t From Tutor t where t.dni like %:dni%")
	List<Tutor> buscarNombreDNI(String dni);
}
