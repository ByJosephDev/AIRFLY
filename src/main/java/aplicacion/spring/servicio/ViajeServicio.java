package aplicacion.spring.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacion.spring.modelo.Viaje;
import aplicacion.spring.repositorio.IViaje;

@Service("viaje")
public class ViajeServicio {
	
	@Autowired
	private IViaje viajerepo;
	
	//listar clientes
	public List<Viaje> listar() {
			
		return viajerepo.findAll();
	
	}
	
	//buscar cliente
	public Viaje buscar(int id) {
		
		return viajerepo.findById(id);
		
	}
	
	//guardar cliente  
	public boolean guardar(Viaje viaje) {
		 
		try {
			 
			viajerepo.save(viaje); 
			return true;
		  
		} catch (Exception e) {
			
			return false;
		  
		}
		  
	}
		
	//eliminar cliente 
	public boolean eliminar(int id) {
				
	    try {
	    	
	    	viajerepo.delete(viajerepo.findById(id)); 
	    	return true;
	    	
	    } catch (Exception e) {
	    	
	    	return false;
	    	
	    }
	  
	}
	 
}
