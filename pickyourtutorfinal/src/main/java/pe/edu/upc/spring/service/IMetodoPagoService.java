package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.MetodoPago;



public interface IMetodoPagoService {

	public boolean insertar (MetodoPago metodopago);
	public boolean modificar (MetodoPago metodopago);
	public void eliminar (int idMetodoPago);
	public Optional<MetodoPago> listarId(int idMetodoPago);
	List<MetodoPago> listar();
	List<MetodoPago> buscarNombre (String nombre);
	
}
