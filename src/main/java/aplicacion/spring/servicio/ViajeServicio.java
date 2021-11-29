package aplicacion.spring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacion.spring.modelo.Cliente;
import aplicacion.spring.modelo.Viaje;
import aplicacion.spring.repositorio.ICliente;
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
	
	/*
	 * //guardar cliente public boolean guardar(Cliente cliente) {
	 * 
	 * try {
	 * 
	 * clienterepo.save(cliente); return true;
	 * 
	 * } catch (Exception e) {
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * //eliminar cliente public boolean eliminar(int id) {
	 * 
	 * try {
	 * 
	 * clienterepo.delete(clienterepo.findById(id)); return true;
	 * 
	 * } catch (Exception e) {
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * }
	 */

}
