package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Tutor;
import pe.edu.upc.entity.ReseņaTutor;


import pe.edu.upc.service.ITutorService;
import pe.edu.upc.service.IReseņaTutorService;

@Named
@RequestScoped

public class ReseņaTutorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITutorService tService;	

	@Inject
	private IReseņaTutorService rtService;	

	private Tutor tutor;
	private ReseņaTutor reseņatutor;

	List<Tutor> listaTutores;
	List<ReseņaTutor> listaReseņaTutor;

	@PostConstruct
	public void init() {

		tutor = new Tutor();
		reseņatutor = new ReseņaTutor();

		listaTutores= new ArrayList<Tutor>();
		listaReseņaTutor = new ArrayList<ReseņaTutor>();
		
		this.listReseņaTutor();
		this.listTutor();
	}

	public String nuevoCursoTutor() {
		this.setReseņatutor(new ReseņaTutor());
		return "reseņatutor.xhtml";
	}

	public void insertar() {
		System.out.println("Método insertar");
		rtService.insertar(reseņatutor);
		limpiarReseņaTutor();
		this.listReseņaTutor();
	}

	public void listReseņaTutor() {
		listaReseņaTutor = rtService.listar();
	}

	
	public void listTutor() {
		listaTutores = tService.listar();
	}

	public void limpiarReseņaTutor() {
		this.init();
	}

	public void eliminar(ReseņaTutor reseņatutor) {
		rtService.eliminar(reseņatutor.getIdReseņaTutor());
		this.listReseņaTutor();
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public ReseņaTutor getReseņatutor() {
		return reseņatutor;
	}

	public void setReseņatutor(ReseņaTutor reseņatutor) {
		this.reseņatutor = reseņatutor;
	}

	public List<Tutor> getListaTutores() {
		return listaTutores;
	}

	public void setListaTutores(List<Tutor> listaTutores) {
		this.listaTutores = listaTutores;
	}

	public List<ReseņaTutor> getListaReseņaTutor() {
		return listaReseņaTutor;
	}

	public void setListaReseņaTutor(List<ReseņaTutor> listaReseņaTutor) {
		this.listaReseņaTutor = listaReseņaTutor;
	}



}