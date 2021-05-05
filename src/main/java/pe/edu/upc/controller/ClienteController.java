package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Named
@RequestScoped


public class ClienteController implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Inject
	private IClienteService mService;
	private Cliente cliente;
	List<Cliente> listaClientes;
	
	@PostConstruct
	public void init()
	{
		this.listaClientes = new ArrayList<Cliente>();
		this.cliente =new Cliente();
		this.listar();
	}
	
	public String nuevoCliente()
	{
		this.setCliente(new Cliente());
		return "cliente.xhtml";
	}

	public void insertar()
	{
		mService.insertar(cliente);
		limpiarCliente();
	}
	
	public void listar()
	{
		listaClientes= mService.listar();
	}
	
	public void limpiarCliente()
	{
		this.init();
	}
	
	public void eliminar(Cliente cliente)
	{
		mService.eliminar(cliente.getIdCliente());
		this.listar();
	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
