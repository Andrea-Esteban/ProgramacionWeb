package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.CursoTutor;


import pe.edu.upc.service.ICursoService;
import pe.edu.upc.service.ICursoTutorService;

@Named
@RequestScoped

public class CursoTutorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICursoService cService;	

	@Inject
	private ICursoTutorService ctService;	

	private Curso curso;
	private CursoTutor cursotutor;

	List<Curso> listaCursos;
	List<CursoTutor> listaCursoTutor;

	@PostConstruct
	public void init() {

		curso = new Curso();
		cursotutor= new CursoTutor();

		listaCursos= new ArrayList<Curso>();
		listaCursoTutor = new ArrayList<CursoTutor>();
		
		this.listCursoTutor();
		this.listCurso();
	}

	public String nuevoCursoTutor() {
		this.setCursotutor(new CursoTutor());
		return "cursotutor.xhtml";
	}

	public void insertar() {
		System.out.println("Método insertar");
		ctService.insertar(cursotutor);
		limpiarCursoTutor();
		this.listCursoTutor();
	}

	public void listCursoTutor() {
		listaCursoTutor = ctService.listar();
	}

	
	public void listCurso() {
		listaCursos = cService.listar();
	}

	public void limpiarCursoTutor() {
		this.init();
	}

	public void eliminar(CursoTutor cursotutor) {
		ctService.eliminar(cursotutor.getIdCursoTutor());
		this.listCursoTutor();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoTutor getCursotutor() {
		return cursotutor;
	}

	public void setCursotutor(CursoTutor cursotutor) {
		this.cursotutor = cursotutor;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public List<CursoTutor> getListaCursoTutor() {
		return listaCursoTutor;
	}

	public void setListaCursoTutor(List<CursoTutor> listaCursoTutor) {
		this.listaCursoTutor = listaCursoTutor;
	}


}