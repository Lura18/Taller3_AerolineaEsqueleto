package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de un avion que es propiedad de la aerolínea y se asignan a los vuelos.
 */

public class Avion {
 
	//Atributos
	private String nombre;
	private int capacidad;
	
	
	//Contructor
	public Avion(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	//Métodos
	public String getNombre() {
		return nombre;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
}
