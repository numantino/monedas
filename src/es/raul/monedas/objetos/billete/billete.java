package es.raul.monedas.objetos.billete;

public class billete {
	private int idBillete;
	private String pais;
	private String denominacionBillete;
	private int fecha;
	private String nota;


	public billete(int idBillete, String pais, String denominacionBillete, int fecha, String nota) {
		this.idBillete = idBillete;
		this.pais = pais;
		this.denominacionBillete = denominacionBillete;
		this.fecha = fecha;
		this.nota = nota;
	}
	//***************************** GETTERS AND SETTERS ******************************************************
	public int getIdBillete() {
		return idBillete;
	}
	public void setIdBillete(int idBillete) {
		this.idBillete = idBillete;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDenominacionBillete() {
		return denominacionBillete;
	}
	public void setDenominacionBillete(String denominacionBillete) {
		this.denominacionBillete = denominacionBillete;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String mostrarInformacion() {
		String fechaString=null;
		try {
			fechaString=Integer.toString(fecha);
			if (fecha==0) fechaString=null;
		}
		catch (Exception e) {}
		String valor;
		if (fechaString!=null) valor="Billete de " + pais + " de " + denominacionBillete + " del año " + fechaString;
		else valor="Billete de " + pais + " de " + denominacionBillete;

		return valor;
	}
	@Override
	public String toString() {
		return "billete [idBillete=" + idBillete + ", pais=" + pais + ", denominacionBillete=" + denominacionBillete
				+ ", fecha=" + fecha + ", nota=" + nota + "]";
	}
}
