package aplicacion.spring.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicacion.spring.modelo.Viaje;
import aplicacion.spring.servicio.ViajeServicio;

@Controller
@RequestMapping(path = "/viajes")
@SessionAttributes("viaje")
public class ViajeControlador {
	
	@Autowired
	@Qualifier("viaje")
	private ViajeServicio viajeservicio;
	
	//mostrar viajes
	@RequestMapping(path = "/listar")
	public String listar(Model model) {
		
		List<Viaje> viajes = viajeservicio.listar();
		model.addAttribute("viajes", viajes);
		model.addAttribute("titulo","Lista de viajes");
		return "viajeListar";
		
	}
	
	//ir al formulario
	@RequestMapping(path = "/formulario")
	public String formulario (Map<String, Object> model) {
		
		Viaje viaje = new Viaje();
		model.put("viaje", viaje);
		model.put("btn", "Registrar viaje");
		return "viajeForm";
		
	}
	
	//actualizar viaje
	@RequestMapping(path = "/formulario/{id}")
	public String actualizar(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("viaje", viajeservicio.buscar(id));
		model.addAttribute("btn", "Actualizar viaje");
		return "viajeForm";
		
	}
	
	//guardar viaje
	@RequestMapping(path = "insertar", method = RequestMethod.POST )
	public String guardar(@Validated Viaje viaje, Model model) {
		
		if(viajeservicio.guardar(viaje)) {
			
			return "redirect:/viajes/listar";
			
		}else {
			
			model.addAttribute("ERROR", "No se puedo registrar el viaje");
			viaje = new Viaje();
			model.addAttribute("viaje", viaje);
			model.addAttribute("btn", "Registrar viaje");
			return "viajeForm";
			
		}
		
	}
	
	//eliminar viaje
	@RequestMapping(path = "/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		
		viajeservicio.eliminar(id);
		return "redirect:/viajes/listar";
		
	}
	
}
