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
import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService cService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoClientes(Map<String, Object> model) {
		model.put("listaClientes", cService.listar());
		return "cliente/listCliente";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/cliente";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Cliente objCliente, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "cliente/cliente";
		else {
			boolean flag = cService.insertar(objCliente);
			if (flag)
				return "redirect:/cliente/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Cliente> objCliente = cService.listarId(id);
		if (objCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/cliente/listar";
		} else {
			model.addAttribute("cliente", objCliente);
			return "cliente/cliente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaClientes", cService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaClientes", cService.listar());
		}
		return "cliente/listCliente";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientes", cService.listar());
		return "cliente/listCliente";
	}
}