package pe.edu.upc.spring.controller;

import java.util.Map;
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


import pe.edu.upc.spring.model.ResenaTutor;

import pe.edu.upc.spring.service.IResenaTutorService;
import pe.edu.upc.spring.service.IClienteService;
import pe.edu.upc.spring.service.ITutorService;

@Controller
@RequestMapping("/resenatutor")
public class ResenaTutorController {

	@Autowired
	private IResenaTutorService cService;
	
	@Autowired
	private IClienteService clService;
	
	@Autowired
	private ITutorService tService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoResena(Map<String, Object> model) {
		model.put("listaResenaTutor", cService.listar());
		return "resenatutor/listResenaTutor";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("resenatutor", new ResenaTutor());
		model.addAttribute("listaClientes", clService.listar());
		model.addAttribute("listaTutores", tService.listar());
		return "resenatutor/resenatutor";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute ResenaTutor objResena, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "resenatutor/resenatutor";
		}else {
			boolean flag = cService.insertar(objResena);
			if (flag)
				return "redirect:/resenatutor/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/resenatutor/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		ResenaTutor objResena = cService.listarId(id).get();
		if (objResena == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/resenatutor/listar";
		} else {
			model.addAttribute("listaClientes", clService.listar());
			model.addAttribute("listaTutores", tService.listar());
			model.addAttribute("resenatutor", objResena);
			return "resenatutor/resenatutor";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaResenaTutor", cService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaResenaTutor", cService.listar());
		}
		return "resenatutor/listResenaTutor";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaResenaTutor", cService.listar());
		return "resenatutor/listResenaTutor";
	}
	

	
}
