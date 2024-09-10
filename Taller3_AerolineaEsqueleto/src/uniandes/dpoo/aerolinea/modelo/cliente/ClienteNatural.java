package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{

	// Atributos
	public final String NATURAL= "Natural";
	private String nombre;
	
	//Constructor
	public ClienteNatural(String nombre) {
		this.nombre = nombre;
	}

	// Métodos
	@Override
	public String getIdentificador() {
		return "" + Math.random()*10e5;
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}
	

}
