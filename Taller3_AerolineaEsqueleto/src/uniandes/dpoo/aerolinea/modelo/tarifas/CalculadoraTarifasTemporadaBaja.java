package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

	// Atributos
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		int costoPorKm = 0;
		if (cliente instanceof ClienteCorporativo) {
			costoPorKm = COSTO_POR_KM_CORPORATIVO;
		} else {
			costoPorKm = COSTO_POR_KM_NATURAL;
		}
		return distancia*costoPorKm;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		
		double descuento = 0;
		if (cliente instanceof ClienteCorporativo) {
			ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
			
			int tamano = corporativo.getTamanoEmpresa();
			
	        if (tamano == corporativo.GRANDE) {
	            descuento = DESCUENTO_GRANDES;
	        } else if (tamano == corporativo.MEDIANA) {
	            descuento = DESCUENTO_MEDIANAS;
	        } else if (tamano == corporativo.PEQUEÑA) {
	            descuento = DESCUENTO_PEQ;
	        }

		}
		return descuento;
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
