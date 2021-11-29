package aplicacion.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicacion.spring.modelo.Cliente;

public interface ICliente extends JpaRepository<Cliente, Integer> {
	
	public abstract Cliente findById(int id);

}
