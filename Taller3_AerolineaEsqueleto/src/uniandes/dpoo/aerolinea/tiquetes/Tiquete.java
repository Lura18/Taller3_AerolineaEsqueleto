package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {

	// Atributos
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente clienteComprador;
	
	//Constructor
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		super();
		this.codigo = codigo;
		this.vuelo = vuelo;
		this.clienteComprador = clienteComprador;
		this.tarifa = tarifa;
	}

	//Métodos
	public String getCodigo() {
		return codigo;
	}

	public int getTarifa() {
		return tarifa;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public Cliente getClienteComprador() {
		return clienteComprador;
	}
	
	public void marcarComoUsado() {
		usado = true;
	}
	public boolean esUsado() {
		return usado;
	}
}
