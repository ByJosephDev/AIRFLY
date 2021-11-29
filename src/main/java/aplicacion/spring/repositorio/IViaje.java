package aplicacion.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicacion.spring.modelo.Viaje;

public interface IViaje extends JpaRepository<Viaje, Integer>{
	
	public abstract Viaje findById(int id);

}
