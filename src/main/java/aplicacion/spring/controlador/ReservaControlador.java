package aplicacion.spring.controlador;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicacion.spring.modelo.Reserva;
import aplicacion.spring.servicio.ClienteServicio;
import aplicacion.spring.servicio.ReservaServicio;
import aplicacion.spring.servicio.ViajeServicio;

@Controller
@RequestMapping(path = "/reservas")
@SessionAttributes("reserva")
public class ReservaControlador {
	
	@Autowired
	@Qualifier("reserva")
	private ReservaServicio reservaservicio;
	
	@Autowired
	@Qualifier("cliente")
	private ClienteServicio clienteservicio;
	
	@Autowired
	@Qualifier("viaje")
	private ViajeServicio viajeservicio;
	
	//mostrar reservas
	@RequestMapping(path = "/listar")
	public String listar(Model model) {
		
		List<Reserva> reservas = reservaservicio.listar();
		model.addAttribute("reservas", reservas);
		model.addAttribute("titulo","Lista de reservas");
		return "reservaListar";
		
	}
	
	//mostrar formulario
	@RequestMapping(path = "/formulario")
	public String formulario(Model model) {
		
		Reserva reserva = new Reserva();
		model.addAttribute("reserva", reserva);
		model.addAttribute("clientes", clienteservicio.listar());
		model.addAttribute("viajes", viajeservicio.listar());
		model.addAttribute("btn", "Registrar venta");
		return "reservaForm";
		
	}
	
	//actualizar reserva
	@RequestMapping(path = "/formulario/{id}")
	public String actualizar (@PathVariable("id") int id, Model model) {
		
		model.addAttribute("reserva", reservaservicio.buscar(id));
		model.addAttribute("clientes", clienteservicio.listar());
		model.addAttribute("viajes", viajeservicio.listar());
		model.addAttribute("btn", "Actualizar reserva");
		return "reservaForm";
		
	}
	
	//registrar reserva
	@RequestMapping(path = "/insertar")
	public String guardar(@Validated Reserva reserva, Model model) {
		
		if(reservaservicio.guardar(reserva)) {
			
			return "redirect:/reservas/listar";
			
		}else {
			
			model.addAttribute("ERROR", "No se puedo registrar la reserva");
			reserva = new Reserva();
			model.addAttribute("reserva", reserva);
			model.addAttribute("btn", "Registrar reserva");
			return "reservaForm";
			
		}
		
	}
	
	//eliminar reserva
	@RequestMapping(path = "/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		
		reservaservicio.eliminar(id);
		return "redirect:/reservas/listar";
		
	}
	
	
}
