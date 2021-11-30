package aplicacion.spring.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacion.spring.modelo.Reserva;
import aplicacion.spring.repositorio.IReserva;

@Service("reserva")
public class ReservaServicio {
	
	@Autowired
	private IReserva reservarepo;
	
	//listar reservas
	public List<Reserva> listar() {
				
		return reservarepo.findAll();
		
	}
	
	

}
