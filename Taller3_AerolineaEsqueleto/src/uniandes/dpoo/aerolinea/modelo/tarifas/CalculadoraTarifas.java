package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

	// Atributos
	public final double IMPUESTO = 0.28;
	
	//Metodos
	public abstract int calcularTarifa(Vuelo vuelo, Cliente cliente);	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		return distancia;
	}
	
	protected abstract int calcularValorImpuestos(int costoBase);
}
