package pe.edu.upc.spring.controller;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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
import pe.edu.upc.spring.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private ICursoService curService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "curso/bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoTutores(Map<String, Object> model) {
		model.put("listaCursos", curService.listar());
		return "curso/listCurso";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("curso", new Curso());
		return "curso/curso";
	}

	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute Curso objCurso, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "curso/curso";
		else {
			boolean flag = curService.insertar(objCurso);
			if (flag)
				return "redirect:/curso/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/curso/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Curso> objCurso = curService.listarId(id);
		if (objCurso == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/curso/listar";
		} else {
			model.addAttribute("curso", objCurso);
			return "curso/curso";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				curService.eliminar(id);
				model.put("listaCurso", curService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaCurso", curService.listar());
		}
		return "curso/listCurso";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaCurso", curService.listar());
		return "curso/listCurso";
	}
}