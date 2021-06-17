package pe.edu.upc.spring.controller;

import java.text.ParseException;
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

import pe.edu.upc.spring.model.MetodoPago;
import pe.edu.upc.spring.service.IMetodoPagoService;


@Controller
@RequestMapping("/metodopago")
public class MetodoPagoController {

	@Autowired
	private IMetodoPagoService cService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoMetodoPago(Map<String, Object> model) {
		model.put("listaMetodoPago", cService.listar());
		return "metodopago/listMetodoPago";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("metodopago", new MetodoPago());
		return "metodopago/metodopago";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute MetodoPago objMetodoPago, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "metodopago/metodopago";
		else {
			boolean flag = cService.insertar(objMetodoPago);
			if (flag)
				return "redirect:/metodopago/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/metodopago/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<MetodoPago> objMetodoPago = cService.listarId(id);
		if (objMetodoPago == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/metodopago/listar";
		} else {
			model.addAttribute("metodopago", objMetodoPago);
			return "metodopago/metodopago";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaMetodoPago", cService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaMetodoPago", cService.listar());
		}
		return "metodopago/listMetodoPago";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMetodoPago", cService.listar());
		return "metodopago/listMetodoPago";
	}
	
	
	
	
	
	
}
