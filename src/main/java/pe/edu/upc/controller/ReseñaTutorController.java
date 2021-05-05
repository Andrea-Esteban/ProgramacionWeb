package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Tutor;
import pe.edu.upc.entity.ReseñaTutor;


import pe.edu.upc.service.ITutorService;
import pe.edu.upc.service.IReseñaTutorService;

@Named
@RequestScoped

public class ReseñaTutorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITutorService tService;	

	@Inject
	private IReseñaTutorService rtService;	

	private Tutor tutor;
	private ReseñaTutor reseñatutor;

	List<Tutor> listaTutores;
	List<ReseñaTutor> listaReseñaTutor;

	@PostConstruct
	public void init() {

		tutor = new Tutor();
		reseñatutor = new ReseñaTutor();

		listaTutores= new ArrayList<Tutor>();
		listaReseñaTutor = new ArrayList<ReseñaTutor>();
		
		this.listReseñaTutor();
		this.listTutor();
	}

	public String nuevoCursoTutor() {
		this.setReseñatutor(new ReseñaTutor());
		return "reseñatutor.xhtml";
	}

	public void insertar() {
		System.out.println("Método insertar");
		rtService.insertar(reseñatutor);
		limpiarReseñaTutor();
		this.listReseñaTutor();
	}

	public void listReseñaTutor() {
		listaReseñaTutor = rtService.listar();
	}

	
	public void listTutor() {
		listaTutores = tService.listar();
	}

	public void limpiarReseñaTutor() {
		this.init();
	}

	public void eliminar(ReseñaTutor reseñatutor) {
		rtService.eliminar(reseñatutor.getIdReseñaTutor());
		this.listReseñaTutor();
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public ReseñaTutor getReseñatutor() {
		return reseñatutor;
	}

	public void setReseñatutor(ReseñaTutor reseñatutor) {
		this.reseñatutor = reseñatutor;
	}

	public List<Tutor> getListaTutores() {
		return listaTutores;
	}

	public void setListaTutores(List<Tutor> listaTutores) {
		this.listaTutores = listaTutores;
	}

	public List<ReseñaTutor> getListaReseñaTutor() {
		return listaReseñaTutor;
	}

	public void setListaReseñaTutor(List<ReseñaTutor> listaReseñaTutor) {
		this.listaReseñaTutor = listaReseñaTutor;
	}



}