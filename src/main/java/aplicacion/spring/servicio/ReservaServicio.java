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
	
	//buscar reserva
	public Reserva buscar(int id) {
		
		return reservarepo.findById(id);
		
	}
	
	//guardar reserva
	public boolean guardar(Reserva reserva) {
		
		try {
			
			reservarepo.save(reserva);
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	
	//eliminar reserva
	public boolean eliminar(int id) {
		
		try {
			
			reservarepo.delete(reservarepo.findById(id));
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}
		
	}

}
