package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase tiene la información de un vuelo de una aerolínea.
 */

public class Vuelo {

//Atributos
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Collection<Tiquete> tiquetes;

//Constructor

	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquetes = new ArrayList<Tiquete>();
    }

//Métodos
	
	public String getFecha() {
		return fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Avion getAvion() {
		return avion;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {

    	int tarifa = calculadora.calcularTarifa(this, cliente);
    	
        for (int i = 0; i < cantidad; i++) {
            Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
            GeneradorTiquetes.registrarTiquete(nuevoTiquete);
            tiquetes.add(nuevoTiquete);  
        }

        int total = tarifa * cantidad;
        return total;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vuelo vuelo = (Vuelo) obj;
        return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion);
	}
}
