package aplicacion.spring.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import aplicacion.spring.modelo.Reserva;

public interface IReserva extends JpaRepository<Reserva, Integer> {

	public abstract Reserva findById(int id);
	
}
