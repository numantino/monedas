package es.raul.monedas.objetos.euros;

/**
 * 
 * @author rgtarancon
 * 
 * Estructura de las monedas conmemorativas de 2E
 *
 */
public class monedaEuroCon{	
	private String pais;
	private String fecha;
	private String descripcion;
	
	public monedaEuroCon(String p, String f, String d){
		this.pais = p;
		this.fecha = f;
		this.descripcion = d;
	}
	
	public String getPais(){
		return this.pais;
	}
	public String getFecha(){
		return this.fecha;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	//To String
	public String toString() { 
		return pais + " del año " + fecha;
	}
}
