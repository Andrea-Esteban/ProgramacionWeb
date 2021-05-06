package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Curso;
import pe.edu.upc.service.ICursoService;

@Named
@RequestScoped

public class CursoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICursoService mService;
	
	private Curso curso;
	List<Curso> listaCursos;
	
	@PostConstruct
	public void init() {
		this.listaCursos = new ArrayList<Curso>();
		this.curso = new Curso();
		this.listar();
	}
	
	public String nuevoCurso() {
		this.setCurso(new Curso());
		return "curso.xhtml";
	}
	
	public void insertar() {
		mService.insertar(curso);
		limpiarCurso();
		this.listar();
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public void listar() {
		listaCursos = mService.listar();
	}
	
	public void limpiarCurso() {
		this.init();
	}
	
	public void eliminar(Curso curso) {
		mService.eliminar(curso.getIdCurso());
		this.listar();
	}

	

}
