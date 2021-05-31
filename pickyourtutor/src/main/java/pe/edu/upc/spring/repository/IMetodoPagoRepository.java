package pe.edu.upc.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.MetodoPago;

@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

	@Query("From MetodoPago c where c.nombre like %:nombre%")
	List<MetodoPago> buscarNombre(@Param("nombre")String nombre);
	
}
