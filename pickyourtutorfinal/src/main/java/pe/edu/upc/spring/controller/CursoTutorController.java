package pe.edu.upc.spring.controller;
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


import pe.edu.upc.spring.model.CursoTutor;

import pe.edu.upc.spring.service.ICursoTutorService;
import pe.edu.upc.spring.service.ITutorService;
import pe.edu.upc.spring.service.ICursoService;

@Controller
@RequestMapping("/cursotutor")
public class CursoTutorController {

	@Autowired
	private ICursoTutorService curtuService;
	@Autowired
	private ICursoService cService;
	@Autowired
	private ITutorService tService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoTutores(Map<String, Object> model) {
		model.put("listaCursoTutor", curtuService.listar());
		return "cursotutor/listCursoTutor";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("cursotutor", new CursoTutor());
		model.addAttribute("listaTutores", tService.listar());
		model.addAttribute("listaCursos", cService.listar());

					return "cursotutor/cursotutor";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute CursoTutor objCursoTutor, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
				return "cursotutor/cursotutor";
		}else {
			boolean flag = curtuService.insertar(objCursoTutor);
			if (flag)
				return "redirect:/cursotutor/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/cursotutor/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<CursoTutor> objCursoTutor = curtuService.listarId(id);
		if (objCursoTutor == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/cursotutor/listar";
		} else {
			model.addAttribute("listaCursos", cService.listar());
			model.addAttribute("listaTutores", tService.listar());
			model.addAttribute("cursotutor", objCursoTutor);

			return "cursotutor/cursotutor";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				curtuService.eliminar(id);
				model.put("listaCursoTutor", curtuService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaCursoTutor", curtuService.listar());
		}
		return "cursotutor/listCursoTutor";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaCursoTutor", curtuService.listar());
		return "cursotutor/listCursoTutor";
	}
}