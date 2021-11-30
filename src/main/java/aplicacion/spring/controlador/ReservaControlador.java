package aplicacion.spring.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
