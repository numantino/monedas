package es.raul.monedasAPP.objetos;

/**
 * Objeto creado para mostrar la informacion de la moneda que se muestra en los botones visuales
 *
 */
public class informacionBotonMoneda {
	private int idMoneda;
	private String nombre;
	private String valorAux;
	private String pathImagen;
	private boolean tengoMonedaEuro;
	
	public informacionBotonMoneda(){
		this.nombre = "";
		this.pathImagen = "";
		this.valorAux= "";
		this.tengoMonedaEuro=false;
		this.idMoneda=0;
	}
	public informacionBotonMoneda(String nombre, String pathImagen) {
		this.nombre = nombre;
		this.pathImagen = pathImagen;
		this.tengoMonedaEuro=true;
		this.idMoneda=0;
		this.valorAux= "";
	}
	public informacionBotonMoneda(String nombre, String pathImagen, boolean tengo, String valor) {
		this.nombre = nombre;
		this.pathImagen = pathImagen;
		this.tengoMonedaEuro=tengo;
		this.idMoneda=0;
		this.valorAux= valor;
	}
	public informacionBotonMoneda(String nombre, String pathImagen, int id, String valorAux, boolean t) {
		this.nombre = nombre;
		this.pathImagen = pathImagen;
		this.tengoMonedaEuro=t;
		this.idMoneda=id;
		this.valorAux= valorAux;
	}
	
	
	public String getValorAux() {
		return valorAux;
	}
	public void setValorAux(String valorAux) {
		this.valorAux = valorAux;
	}
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPathImagen() {
		return pathImagen;
	}
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	public boolean isTengoMonedaEuro() {
		return tengoMonedaEuro;
	}
	public void setTengoMonedaEuro() {
		this.tengoMonedaEuro = true;
	}
	
}
