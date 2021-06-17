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

import pe.edu.upc.spring.model.Pago;
import pe.edu.upc.spring.service.IMetodoPagoService;
import pe.edu.upc.spring.service.IPagoService;

@Controller
@RequestMapping("/pago")
public class PagoController {

	@Autowired
	private IPagoService pService;
	
	@Autowired
	private IMetodoPagoService mService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoPagos(Map<String, Object> model) {
		model.put("listaPagos", pService.listar());
		return "pago/listPago";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("pago", new Pago());
		model.addAttribute("listaMetodoPago", mService.listar());
		return "pago/pago";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Pago objPago, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "pago/pago";
		else {
			boolean flag = pService.insertar(objPago);
			if (flag)
				return "redirect:/pago/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/pago/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Pago> objPago = pService.listarId(id);
		if (objPago == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/pago/listar";
		} else {
			model.addAttribute("listaMetodoPago", mService.listar());
			model.addAttribute("pago", objPago);
			return "pago/pago";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaPagos", pService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPago", pService.listar());
		}
		return "pago/listPago";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPagos", pService.listar());
		return "pago/listPago";
	}
}