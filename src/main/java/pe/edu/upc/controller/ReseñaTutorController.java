package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Tutor;
import pe.edu.upc.entity.Rese�aTutor;


import pe.edu.upc.service.ITutorService;
import pe.edu.upc.service.IRese�aTutorService;

@Named
@RequestScoped

public class Rese�aTutorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITutorService tService;	

	@Inject
	private IRese�aTutorService rtService;	

	private Tutor tutor;
	private Rese�aTutor rese�atutor;

	List<Tutor> listaTutores;
	List<Rese�aTutor> listaRese�aTutor;

	@PostConstruct
	public void init() {

		tutor = new Tutor();
		rese�atutor = new Rese�aTutor();

		listaTutores= new ArrayList<Tutor>();
		listaRese�aTutor = new ArrayList<Rese�aTutor>();
		
		this.listRese�aTutor();
		this.listTutor();
	}

	public String nuevoCursoTutor() {
		this.setRese�atutor(new Rese�aTutor());
		return "rese�atutor.xhtml";
	}

	public void insertar() {
		System.out.println("M�todo insertar");
		rtService.insertar(rese�atutor);
		limpiarRese�aTutor();
		this.listRese�aTutor();
	}

	public void listRese�aTutor() {
		listaRese�aTutor = rtService.listar();
	}

	
	public void listTutor() {
		listaTutores = tService.listar();
	}

	public void limpiarRese�aTutor() {
		this.init();
	}

	public void eliminar(Rese�aTutor rese�atutor) {
		rtService.eliminar(rese�atutor.getIdRese�aTutor());
		this.listRese�aTutor();
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Rese�aTutor getRese�atutor() {
		return rese�atutor;
	}

	public void setRese�atutor(Rese�aTutor rese�atutor) {
		this.rese�atutor = rese�atutor;
	}

	public List<Tutor> getListaTutores() {
		return listaTutores;
	}

	public void setListaTutores(List<Tutor> listaTutores) {
		this.listaTutores = listaTutores;
	}

	public List<Rese�aTutor> getListaRese�aTutor() {
		return listaRese�aTutor;
	}

	public void setListaRese�aTutor(List<Rese�aTutor> listaRese�aTutor) {
		this.listaRese�aTutor = listaRese�aTutor;
	}



}