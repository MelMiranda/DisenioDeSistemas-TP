package domain;

import org.joda.time.DateTime;

public class LineaReporte {
	
	private DateTime fechaBusqueda;
	private int cantPoisBusqueda ;
	
	
	public LineaReporte(DateTime fechaBusqueda, int cantPoisBusqueda) {
		super();
		this.fechaBusqueda = fechaBusqueda;
		this.cantPoisBusqueda = cantPoisBusqueda;
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
