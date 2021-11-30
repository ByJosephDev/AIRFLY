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

import aplicacion.spring.modelo.Cliente;
import aplicacion.spring.servicio.ClienteServicio;

@Controller
@RequestMapping(path = "/clientes")
@SessionAttributes("cliente")
public class ClienteControlador {
	
	@Autowired
	@Qualifier("cliente")
	private ClienteServicio clienteservicio;

	//mostrar clientes
	@RequestMapping(path = "/listar")
	public String listar(Model model) {
		
		List<Cliente> clientes = clienteservicio.listar();
		model.addAttribute("clientes", clientes);
		model.addAttribute("titulo", "Lista de clientes");
		return "clienteListar";
		
	}
	
	//ir al formulario
	@RequestMapping(path = "/formulario")
	public String formulario (Map<String, Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("btn", "Registrar persona");
		return "clienteForm";
		
	}
	
	//actualizar cliente
	@RequestMapping(path = "/formulario/{id}")
	public String actualizar(@PathVariable("id") int id, Model model) {
			
		model.addAttribute("cliente", clienteservicio.buscar(id));
		model.addAttribute("btn", "Actualizar persona");
		return "clienteForm";
			
	}
	
	//guardar cliente
	@RequestMapping(path = "/insertar", method = RequestMethod.POST)
	public String guardar(@Validated Cliente cliente, Model model) {
		
		if(clienteservicio.guardar(cliente)) {
			
			return "redirect:/clientes/listar";
			
		}else {
			
			model.addAttribute("ERROR", "Ya existe una persona con ese documento");
			cliente = new Cliente();
			model.addAttribute("cliente", cliente);
			model.addAttribute("btn", "Registrar persona");
			return "clienteForm";
			
		}
		
	}
	
	//eliminar cliente
	@RequestMapping(path = "/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		
		clienteservicio.eliminar(id);
		return "redirect:/clientes/listar";
		
	}
	
}

