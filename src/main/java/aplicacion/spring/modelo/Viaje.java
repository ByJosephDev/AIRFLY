package aplicacion.spring.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viaje")
public class Viaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String lugar_partida;
	
	private String lugar_destino;
	
	private String hora;
	
	private String fecha;
	
	private double precio;

	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLugar_partida() {
		return lugar_partida;
	}

	public void setLugar_partida(String lugar_partida) {
		this.lugar_partida = lugar_partida;
	}

	public String getLugar_destino() {
		return lugar_destino;
	}

	public void setLugar_destino(String lugar_destino) {
		this.lugar_destino = lugar_destino;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}