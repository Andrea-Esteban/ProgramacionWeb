package pe.edu.upc.spring.controller;
import java.util.List;
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
import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.SolicitudClase;
import pe.edu.upc.spring.model.Tutor;
import pe.edu.upc.spring.service.ISolicitudClaseService;

@Controller
@RequestMapping("/solicitudclase")
public class SolicitudClaseController {

	@Autowired
	private ISolicitudClaseService soliService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoTutores(Map<String, Object> model) {
		model.put("listaSolicitudClase", soliService.listar());
		return "listSolicitudClase";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("solicitudclase", new SolicitudClase());
		return "solicitudclase";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute SolicitudClase objSolicitudClase, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "solicitudclase";
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
			return "solicitudclase";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				soliService.eliminar(id);
				model.put("listaSolicitudClase", soliService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaSolicitudClase", soliService.listar());
		}
		return "listSolicitudClase";
		}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaSolicitudClase", soliService.listar());
		return "listSolicitudClase";
	}
	
	@RequestMapping("/irBuscar")
    public String buscar(Model model) {
        model.addAttribute("SolicitudClase", new SolicitudClase());
        return "buscar";
    }
	
	@RequestMapping("/buscar")
    public String findBy(Map<String, Object> model, @ModelAttribute SolicitudClase solicitudClase)
    throws ParseException{
        List<SolicitudClase> listaSolicitudClase;
        Tutor  tutor = new Tutor();
        tutor.setNombre(solicitudClase.getTutor().getNombre());
        solicitudClase.setTutor(tutor);
        listaSolicitudClase = soliService.listarNombreTutor(solicitudClase.getTutor().getNombre());
        if(listaSolicitudClase.isEmpty()) {
        	listaSolicitudClase = soliService.listarNombreCurso(solicitudClase.getTutor().getNombre());
        }
        if (listaSolicitudClase.isEmpty()) {
            model.put("mensaje", "No se encontraron coincidencias");
        }
        model.put("listaSolicitudClase", listaSolicitudClase);
        return "buscar";
    }

    
	
}