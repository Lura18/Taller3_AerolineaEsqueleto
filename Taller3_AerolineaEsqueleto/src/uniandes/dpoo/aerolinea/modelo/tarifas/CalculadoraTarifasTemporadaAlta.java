package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

	//Atributos 
	protected final int COSTO_POR_KM = 1000;
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		int costoPorKm = COSTO_POR_KM;
		return distancia * costoPorKm;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;
	}

	@Override
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		
        int costoBase = calcularCostoBase(vuelo, cliente);
        
        int descuento = (int) (costoBase * calcularPorcentajeDescuento(cliente));
        int costoConDescuento = costoBase - descuento;
        
        int costoConImpuestos = calcularValorImpuestos(costoConDescuento);
        
        return costoConImpuestos;

	}

	@Override
	protected int calcularValorImpuestos(int costoBase) {
		return (int) Math.round(costoBase * (1 + IMPUESTO));
	}

}
