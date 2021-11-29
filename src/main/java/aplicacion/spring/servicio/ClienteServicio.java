package aplicacion.spring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacion.spring.modelo.Cliente;
import aplicacion.spring.repositorio.ICliente;

@Service("cliente")
public class ClienteServicio {
	
	@Autowired
	private ICliente clienterepo;
	
	//listar clientes
	public List<Cliente> listar() {
			
		return clienterepo.findAll();
	
	}
	
	//buscar cliente
	public Cliente buscar(int id) {
		
		return clienterepo.findById(id);
		
	}
	
	//guardar cliente
	public boolean guardar(Cliente cliente) {
		
		try {
			
			clienterepo.save(cliente);
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	
	//eliminar cliente
	public boolean eliminar(int id) {
		
		try {
			
			clienterepo.delete(clienterepo.findById(id));
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	
}
