package pe.edu.upc.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.SolicitudClase;

@Repository
public interface ISolicitudClaseRepository extends JpaRepository<SolicitudClase, Integer> {

	
}
