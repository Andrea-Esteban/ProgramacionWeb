package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Tutor;
import pe.edu.upc.service.ITutorService;

@Named
@RequestScoped

public class TutorController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITutorService Tservice;
	private Tutor tutor;
	List<Tutor> listaTutores;
	
	@PostConstruct
	public void init()
	{
		this.listaTutores = new ArrayList<Tutor>();
		this.tutor =new Tutor();
		this.listar();
	}

	public String nuevoTutor()
	{
		this.setTutor(new Tutor());
		return "tutor.xhtml";

	}
	public void insertar()
	{
		Tservice.insertar(tutor);
		limpiarTutor();
	}
	
	
	public void listar()
	{
		listaTutores=Tservice.listar();
	}
	
	public void limpiarTutor()
	{
		this.init();
	}
	public void eliminar(Tutor tutor)
	{
		Tservice.eliminar(tutor.getIdTutor());
		this.listar();
	}
	
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public List<Tutor> getListaTutores() {
		return listaTutores;
	}

	public void setListaTutores(List<Tutor> listaTutores) {
		this.listaTutores = listaTutores;
	}
	
	

}
