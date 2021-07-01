package pe.edu.upc.spring.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.text.ParseException;

import pe.edu.upc.spring.model.Curso;
import pe.edu.upc.spring.model.CursoTutor;
//import pe.edu.upc.spring.model.CursoTutor;
import pe.edu.upc.spring.model.SolicitudClase;
import pe.edu.upc.spring.model.Tutor;
//import pe.edu.upc.spring.model.Tutor;
import pe.edu.upc.spring.service.ISolicitudClaseService;
import pe.edu.upc.spring.service.ICursoTutorService;

@Controller
@RequestMapping("/solicitudclase")
public class SolicitudClaseController {

	@Autowired
	private ISolicitudClaseService soliService;
	@Autowired
	private ICursoTutorService curstService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoTutores(Map<String, Object> model) {
		model.put("listaSolicitudClase", soliService.listar());
		return "solicitudclase/listSolicitudClase";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("solicitudclase", new SolicitudClase());
		model.addAttribute("listaCursoTutor", curstService.listar());
		return "solicitudclase/solicitudclase";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute SolicitudClase objSolicitudClase, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors())
			return "solicitudclase/solicitudclase";
		else {
			boolean flag = soliService.insertar(objSolicitudClase);
			if (flag)
				return "redirect:/solicitudclase/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/solicitudclase/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<SolicitudClase> objSolicitudClase = soliService.listarId(id);
		if (objSolicitudClase == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/solicitudclase/listar";
		} else {

			model.addAttribute("solicitudclase", objSolicitudClase);
			return "solicitudclase/solicitudclase";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				soliService.eliminar(id);
				model.put("listaSolicitudClase", soliService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaSolicitudClase", soliService.listar());
		}
		return "solicitudclase/listSolicitudClase";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaSolicitudClase", soliService.listar());
		return "solicitudclase/listSolicitudClase";
	}

	@RequestMapping("/irBuscar")
	public String buscar(Model model) {
		model.addAttribute("solicitudClase", new SolicitudClase());
		return "solicitudclase/buscar";
	}

	@RequestMapping("/buscar")
	public String findBy(Map<String, Object> model, @ModelAttribute SolicitudClase solicitudClase)
			throws ParseException {
		List<SolicitudClase> listaSolicitudClase = new ArrayList<SolicitudClase>();
		CursoTutor cursoTutor = new CursoTutor();
		Tutor tutor = new Tutor();
		Curso curso = new Curso();

		tutor.setNombre(solicitudClase.getCursoTutor().getCurso().getNombreCurso());
		curso.setNombreCurso(solicitudClase.getCursoTutor().getCurso().getNombreCurso());
		
		cursoTutor.setTutor(tutor);
		cursoTutor.setCurso(curso);
		
		solicitudClase.setCursoTutor(cursoTutor);
		listaSolicitudClase = soliService.buscarNombreTutor(solicitudClase.getCursoTutor().getTutor().getNombre());
		if (listaSolicitudClase.isEmpty()) {
			listaSolicitudClase = soliService
					.buscarNombreCurso(solicitudClase.getCursoTutor().getCurso().getNombreCurso());
		}
		if (listaSolicitudClase.isEmpty()) {
			model.put("mensaje", "No se encontraron coincidencias");
		}
		model.put("listaSolicitudClase", listaSolicitudClase);
		return "solicitudclase/buscar";
	}

}