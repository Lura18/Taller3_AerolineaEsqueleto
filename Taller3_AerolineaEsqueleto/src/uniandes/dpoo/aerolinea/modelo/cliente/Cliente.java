package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

    // Atributos
    protected Collection<Tiquete> tiquetes;
    
    // Constructor
	public Cliente() {
        this.tiquetes = new ArrayList<>();
    }
	
    //Métodos
	public abstract String getIdentificador();
	public abstract String getTipoCliente();
	
	public void agregarTiquete(Tiquete tiquete) {
        tiquetes.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete tiquete : tiquetes) {
            total += tiquete.getTarifa();
        }
        return total;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete tiquete : tiquetes) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado();
            }    
        }
	}
}
