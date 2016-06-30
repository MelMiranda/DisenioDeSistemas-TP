package domain;

import org.joda.time.DateTime;

public class LineaReporte {
	
	private DateTime fechaBusqueda;
	private int cantPoisBusqueda ;
	private String palabraBuscada;
	
	
	
	public String getPalabraBuscada() {
		return palabraBuscada;
	}
	public void setPalabraBuscada(String palabraBuscada) {
		this.palabraBuscada = palabraBuscada;
	}
	public LineaReporte(DateTime fechaBusqueda, int cantPoisBusqueda,String palabraBscada) {
		super();
		this.fechaBusqueda = fechaBusqueda;
		this.cantPoisBusqueda = cantPoisBusqueda;
		this.palabraBuscada=palabraBscada;
	}
	public DateTime getFechaBusqueda() {
		return fechaBusqueda;
	}
	public void setFechaBusqueda(DateTime fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
	public int getCantPoisBusqueda() {
		return cantPoisBusqueda;
	}
	public void setCantPoisBusqueda(int cantPoisBusqueda) {
		this.cantPoisBusqueda = cantPoisBusqueda;
	}
	
	
	

}
